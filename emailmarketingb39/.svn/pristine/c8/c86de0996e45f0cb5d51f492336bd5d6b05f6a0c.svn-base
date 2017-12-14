



$(document).ready(function() {

	
	$.ajax({
		type : 'Post',
		url : 'ShowMessage',
		datatype : 'json',
		success : function(eventList) {
			
			if (eventList.length>0) {
				$("#no-count").html(eventList.length);
			}
		}
	});
});