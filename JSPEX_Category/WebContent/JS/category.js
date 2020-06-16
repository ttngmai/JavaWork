var num = 1;

$(document).ready(function(){
	loadCategory(num, 0);
});

function loadCategory(depth, parent){
	$.ajax({
		url : "cate_list.ajax?depth=" + depth + "&parent=" + parent
		, type : "GET"
		, cache : false
		, success : function(data, status){
			if(status == "success"){
				
				if(updateCategory(data)) {
					$("#mycate > span:nth-child(" + num + ") > select").change(function(){
						
						if(($('select').index(this)+3) <= 3) {
							$("#mycate > span:nth-child(" + $('select').index(this)+3 + ") > select").empty();
							$("#mycate > span:nth-child(" + $('select').index(this)+3 + ") > select").attr('disabled', true);
						}
						
						var parent = $(this).val();
						console.log("dept: " + ($('select').index(this)+1) + " select: " + parent);
						
						if(depth < 3){
							num = $("select").index(this)+2;
							loadCategory(num, parent);
						}
						
					});
				}
				
			}
		}
	});
}; // end loadCategory()

function updateCategory(jsonObj) {
	text = "<option value=''>--선택하세요--</option>";
	
	if (jsonObj.status == "OK") {

		var count = jsonObj.count;

		var i;
		var items = jsonObj.list;
		
		for (i = 0; i < count; i++) {
			text += "<option value='" + items[i].uid + "'>";
			text += items[i].name;
			text += "</option>";
		} // end for

		$("#mycate > span:nth-child(" + num + ") > select").attr('disabled', false);
		$("#mycate > span:nth-child(" + num + ") > select").html(text);

		return true;
		
	} else {
		alert(jsonObj.message);
		
		return false;
	}
	
	return false;
} // end updateFirstCategory()