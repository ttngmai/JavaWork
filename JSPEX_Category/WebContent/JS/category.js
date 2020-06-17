$(document).ready(function() {
	loadCategory(1, 0);
});

function loadCategory(depth, parent) {
	$.ajax({
		url : "cate_list.ajax"
		, type : "POST"
		, dataType : "json"
		, data : {depth : depth, parent : parent}
		, cache : false
		, success : function(data, status) {
			if(status == "success") {
				
				if(updateCategory(data, depth)) {
					$("#mycate > span:nth-child(" + depth + ") > select").change(function() { // value 선택 시
						for(var j = depth+1; j <= 3; j++) {
							$("#mycate > span:nth-child(" + j + ") > select").empty();
							$("#mycate > span:nth-child(" + j + ") > select").attr('disabled', true);
						}
						
						var selectNum = $('select').index(this)+1; // 몇번째 select? (1~3 번째)
						var parent = $(this).val(); // value 값은? 
						
						if(parent == 0) { // "--선택하세요--" 선택 시 
							console.log("dept: " + selectNum + " select: " + parent);
							depth = selectNum;
							for(var j = selectNum+1; j <= 3; j++) {
								$("#mycate > span:nth-child(" + j + ") > select").empty();
								$("#mycate > span:nth-child(" + j + ") > select").attr('disabled', true);
							}
							
						} else if(depth < 3) { // 유효한 값 선택 시 
							console.log("dept: " + selectNum + " select: " + parent);
							depth = selectNum+1;
							loadCategory(depth, parent);
							return;
						}
					});
				}
				
			}
		}
	});
}; // end loadCategory()

function updateCategory(jsonObj, depth) {
	text = "<option value='0'>--선택하세요--</option>";
	
	if (jsonObj.status == "OK") {

		var count = jsonObj.count;

		var i;
		var items = jsonObj.list;
		
		for (i = 0; i < count; i++) {
			text += "<option value='" + items[i].uid + "'>";
			text += items[i].name;
			text += "</option>";
		} // end for

		$("#mycate > span:nth-child(" + depth + ") > select").attr('disabled', false);
		$("#mycate > span:nth-child(" + depth + ") > select").html(text);
		return true;
		
	} else {
		alert(jsonObj.message);
		return false;
	}
	
	return false;
} // end updateCategory()