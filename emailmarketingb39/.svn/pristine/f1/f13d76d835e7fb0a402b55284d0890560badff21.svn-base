/*form validation*/
$(document).ready(function(){
$("#form1").validate({
   rules: {
      name: 
      {
    	  required:true,
    	  minlength:3,
    	  customvalidation :true,
    	  /*regex:true,*/
    	  },   	  
      dob: 
    	  {
    	  required:true,
    	  date : true,
    	  },
    	   street: 
    	      {
    	    	  required:true,
    	    	  minlength:3,
    	    	  maxlength:100,
    	    	  },   
    	   
      
      mobile : {
             required : true,
             minlength : 10,
             number :true,
             maxlength : 10,
             customvalidation1:true
      },
   },
   messages: {
     name:
    	 {
    	 	required :"<font color='red'>Please enter your name.</font>",
    		minlength: "<font color='red'>Please enter at least 3 characters.</font>",
    	 	 customvalidation:"<font color='red'>please enter alphabets only.</font>",
   },
   street:
	 {
	 	required :"<font color='red'>Please enter your street.</font>",
		minlength: "<font color='red'>Please enter at least 3 characters.</font>",
	 	maxlength: "<font color='red'>Please do not enter more than 100 characters.</font>",
	 	
},
   
   dob : "<font color='red'>Please select your date of birth.</font>",
 
     
     
     mobile : { 
    	 	required: "<font color='red'>Please specify your mobile no.</font>",
    	 	number:"<font color='red'>Please enter only digits.</font>",
    	 	minlength: "<font color='red'>Please enter 10 digits.</font>",
    	 	maxlength: "<font color='red'>Please enter 10 digit only</font>", 
    	 	customvalidation1:"<font color='red'>please enter digit only which should start with 7,8,9.</font>",
    	 	 
     },	 
   },
}) 
 
$('#sub').on('click', function() {
    $("#form1").validate();
});





$.validator.addMethod("customvalidation1", function(value, element) {
	return this.optional(element) || /^[789]\d{9}$/.test(value);
}, "");
 

$.validator.addMethod("customvalidation", function(value, element) {
	
    return this.optional(element) || /^[a-zA-Z," "]+$/i.test(value);
}, "");
});




 /* Trim functions */	
  function trimIt() {
		var str=document.getElementById("name").value;
		var street=document.getElementById("street").value;
		var mobile=document.getElementById("mobile").value;
		var newStr=str.replace(/(^\s+|\s+$)/g,'');
		var newStreet=street.replace(/(^\s+|\s+$)/g,'');
		var newMobile=mobile.replace(/(^\s+|\s+$)/g,'');
		document.getElementById("name").value=newStr;
		document.getElementById("street").value=newStreet;
		document.getElementById("mobile").value=newMobile;
	}
 

/*file upload button*/
$(document).on('click', '#close-preview', function(){ 
	    $('.image-preview').popover('hide');
	    // Hover befor close the preview
	    $('.image-preview').hover(
	        function () {
	           $('.image-preview').popover('show');
	        }, 
	         function () {
	           $('.image-preview').popover('hide');
	        }
	    );    
	});

	$(function() {
	    // Create the close button
	    var closebtn = $('<button/>', {
	        type:"button",
	        text: 'x',
	        id: 'close-preview',
	        style: 'font-size: initial;',
	    });
	    closebtn.attr("class","close pull-right");
	    // Set the popover default content
	    $('.image-preview').popover({
	        trigger:'manual',
	        html:true,
	        title: "<strong>Preview</strong>"+$(closebtn)[0].outerHTML,
	        content: "There's no image",
	        placement:'bottom'
	    });
	    // Clear event
	    $('.image-preview-clear').click(function(){
	        $('.image-preview').attr("data-content","").popover('hide');
	        $('.image-preview-filename').val("");
	        $('.image-preview-clear').hide();
	        $('.image-preview-input input:file').val("");
	        $(".image-preview-input-title").text("Browse"); 
	    }); 
	    // Create the preview image
	    $(".image-preview-input input:file").change(function (){     
	        var img = $('<img/>', {
	            id: 'dynamic',
	            width:250,
	            height:200
	        });      
	        var file = this.files[0];
	        var reader = new FileReader();
	        // Set preview image into the popover data-content
	        reader.onload = function (e) {
	            $(".image-preview-input-title").text("Change");
	            $(".image-preview-clear").show();
	            $(".image-preview-filename").val(file.name);            
	            img.attr('src', e.target.result);
	            $(".image-preview").attr("data-content",$(img)[0].outerHTML).popover("show");
	        }        
	        reader.readAsDataURL(file);
	    });  
	});







 