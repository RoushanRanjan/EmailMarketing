$(document).ready(function(){
	var $url=$("#url").val();
//	$ symbol in variable is for statndard not any other meaning
		$.getJSON($url+"?val=0",function(data) {
			var a=" ";
			$.each(data, function(key,value) {
				a=a+"<option value="+value+">"+key+"</option>"
			});
			$("#country").html(a);
			$("#country").change( function() {
				var $id=$("#country").val();
				$.getJSON($url+"?id="+$id+"&val=1" ,function(data){
					var b=" ";
					$.each(data,function(key,value){
						b=b+"<option value="+value+">"+key+"</option>"
					});
					$("#state").html(b);
					$("#state").change( function() {
						var $id=$("#state").val();
						$.getJSON($url+"?id="+$id+"&val=2" ,function(data){
						var c=" ";
						$.each(data,function(key,value){
							c=c+"<option value="+value+">"+key+"</option>"
						});
						$("#city").html(c);
					});			
				});
				});			
				});
		});
	});