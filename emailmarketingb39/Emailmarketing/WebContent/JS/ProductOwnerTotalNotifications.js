$(document).ready(function(){
	var $url=$("#url").val();
		$.getJSON($url,function(data) {
			var a=" ";
			a="<b>"+data+"</b>"
		$("#ProductOwnerTotalNotificationsId").html(a);
	});
});