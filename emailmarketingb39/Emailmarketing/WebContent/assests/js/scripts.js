
jQuery(document).ready(function() {
    $('#top-navbar-1').on('shown.bs.collapse', function(){
    	$.backstretch("resize");
    });

    $('.registration-form fieldset:first-child').fadeIn('slow');
    
    $('.registration-form input[type="text"], .registration-form input[type="checkbox"], .registration-form input[type="radio"], .registration-form select').on('focus', function() {
    	$(this).removeClass('input-error');
    });    
  
     //*********** Next Step Button Validation
     $('.registration-form .btn-next').on('click', function() {
     	var parent_fieldset = $(this).parents('fieldset');
     	var next_step = true;
     	parent_fieldset.find('input[type="text"], input[type="checkbox"], input[type="radio"], input[type="file"], select').each(function() {
     		if( $(this).val()=="") {
     			$(this).addClass('input-error');
     			$('#personalerror').html("Fill Required Fields");
     			$('#ederror').html("Fill Required Fields");
     			next_step = false;
     		}
     		else if($('input[name="gender"]:checked','#myform').val()==null){
     			$("#gender").addClass('input-error');
     			$("#gender").focus();
     			next_step = false;
     		}
     		else {
     			$(this).removeClass('input-error');
     			$('.help-block').html('');
     		}
     	});
     	
     	if( next_step ) {
     		parent_fieldset.fadeOut(400, function() {
 	    		$(this).next().fadeIn();
 	    	});
     	}
     });
     	
      //************ Previous Step Button Validation ************
     $('.registration-form .btn-previous').on('click', function() {
     	$(this).parents('fieldset').fadeOut(400, function() {
     		$(this).prev().fadeIn();
     	});
     });
   
     //*********** Form Submit Button Validation ***************
     $('.registration-form').on('submit', function(e) {
     	$(this).find('input[type="text"], input[type="checkbox"], input[type="file"], input[type="radio"], select').each(function() {
     		if( $(this).val() == "" ) {
     		      e.preventDefault();
     			$(this).addClass('input-error');
     		}
     		else {
     			$(this).removeClass('input-error');
     		}
     	});
     });

     //************** Form Field Validation**************************
     //DateDropper Code
     $( '.registration-form .form-dob' ).dateDropper();
     
     /*   Generate a simple captcha */
	    function randomNumber(min, max) {
	        return Math.floor(Math.random() * (max - min + 1) + min);
	    }
	    $('#captchaOperation').html([randomNumber(1, 100), '+', randomNumber(1, 200), '='].join(' '));
	    
	      $('.registration-form .fieldSetId1') .formValidation({
	    	 framework: 'bootstrap',
	    	 icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	    	 },
	         row: {
	            valid: 'field-success',
	            invalid: 'field-error'
	         },
	         fields: {
	        	 gender: {
	                 validators: {
	                     notEmpty: {
	                         message: 'Please select gender?.'
	                     }
	                 }
	               }
		     }
	      });//fieldSetId1
	      
	      $('.registration-form .fieldSetId2') .formValidation({
		    	framework: 'bootstrap',
		        icon: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        row: {
		            valid: 'field-success',
		            invalid: 'field-error'
		        }, 
		        fields: {  	 
	            street:{
	            	validators:{
	            		notEmpty:{
	            			message:'The Street is required'
	            		}
	            	}
	            },
	            country:{
	            	validators:{
	            		notEmpty:{
	            			message:'The Contry is required'
	            		}
	            	}
	            },
	            state:{ 
	            	validators:{
	            		notEmpty:{
	            			message:'The State is required'
	            		}
	            	}
	            },
	            city:{
	            	validators:{
	            		notEmpty:{
	            			message:'The City is required'
	            		}
	            	}
	            },
		     }
	      });//fieldSetId2
	 //***************** Education Pass Year Validation **********************     
	      $("#birthday").change(function(){
	    	  	var dob=$("#birthday").val().split("/");
	    	    var f=dob[2]*1+14;
	    	    var ed=f+4;
	    	    var stDate=f.toString();
	    	    var edDate=ed.toString();
	    	    $('#datePicker1') .datepicker({
			    	 format: "yyyy",
			    	 autoclose: true,
			         viewMode: "years", 
			         startDate: stDate,
			         endDate: edDate, 
			         minViewMode: "years"
		        }).on('changeDate', function(e) {
		            $('.registration-form .fieldSetId3').formValidation('revalidateField', 'sscyop');
		        });
	      });
	      
	      $("#sscyop").change(function(){
	    	  	var sscyear=$("#sscyop").val()*1;
	    	    var f=sscyear+1;
	    	    var ed=f+4;
	    	    var stDate=f.toString();
	    	    var edDate=ed.toString();
	    	    $('#datePicker2') .datepicker({
	    	    	autoclose: true,
	    	    	format: "yyyy",
	    	    	viewMode: "years", 
	    	    	startDate:stDate,
	    	    	endDate: edDate, 
	    	    	minViewMode: "years"
	    	    }).on('changeDate', function(e) {
	    	    	$('.registration-form .fieldSetId3').formValidation('revalidateField', 'interyop');
	    	    });
	      });
	      
	      $("#interyop").change(function(){
	    	  	var interyear=$("#interyop").val()*1;
	    	    var f=interyear+2;
	    	    var stDate=f.toString();
	    	    $('#datePicker3')	.datepicker({
	    	    	autoclose: true,
	    	    	format: "yyyy",
	    	    	viewMode: "years", 
	    	    	startDate: stDate,
	    	    	endDate: '+0y', 
	    	    	minViewMode: "years"
	    	    }).on('changeDate', function(e) {
	    	    	$('.registration-form .fieldSetId3').formValidation('revalidateField', 'ugyop');
	    	    });
	      });
		    
		  $("#ugyop").change(function(){
	    	  var ugyear=$("#ugyop").val()*1;
	    	  var f=ugyear+1;
	    	  var stDate=f.toString();
	    	  $('#datePicker4')	.datepicker({
	    		  autoclose: true,
	    		  format: "yyyy",
	    		  viewMode: "years", 
	    		  startDate: stDate,
	    		  endDate: '+0y', 
	    		  minViewMode: "years"
	    	  }).on('changeDate', function(e) {
	    		  $('.registration-form .fieldSetId3').formValidation('revalidateField', 'pgyop');
	    	  });
	      });
	      
	      $('.registration-form .fieldSetId3') .formValidation({
		    	 framework: 'bootstrap',
		         excluded: ':disabled',
		    	 icon: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		         },
		         row: {
		            valid: 'field-success',
		            invalid: 'field-error'
		         }, 
		         fields: {
		        	 	ssc:{
		        	 		 err: 'tooltip',
		        	 		validators:{
		        	 			notEmpty:{
		        	 				message:'The SSC qualification is required'
		        	 			},
		        	 			different: {
		        	 				field: 'inter',
		        	 				message: 'The SSC Qualification cannot be the same as 12th Qualification'
		        	 			},
		        	 		}
		        	 	},
		        	 	sscyop:{
		        	 		 err: 'tooltip',
		        	 		validators:{
		        	 			notEmpty:{
		        	 				message:'The SSC passyear is required'
		        	 			},
		        	 			different: {
		        	 				field: 'interyop',
		        	 				message: 'The SSC passyear cannot be the same as 12th Passyear'
		        	 			},
		        	 		}
		        	 	},
		        	 	sscpersent:{
		        	 		 err: 'tooltip',
		        	 		validators:{
		        	 			notEmpty:{
		        	 				message:'The SSC persent is required'
		        	 			},
		        	 			regexp: {
		        	 				regexp:/^([1-9]([0-9])?|0)(\.[0-9]{1,2})?$/,
		        	 				message: 'Please give valid percentage'
		        	 			}
		        	 		}
		        	 	},
		        	 	
		        	 	inter:{	
		        	 		 err: 'tooltip',
		        	 		validators:{
		        	 			notEmpty:{
		        	 				message:'Select 12th qualification required'
		        	 			},
		        	 			different: {
		        	 				field: 'ssc',
		        	 				message: 'The 12th Qualification cannot be the same as ssc'
		        	 			}
		        	 		}
		        	 	},
		        	 	interyop:{
		        	 		 err: 'tooltip',
		        	 		validators:{
		        	 			notEmpty:{
		        	 				message:'The 12th passyear is required'
		        	 			},
		        	 			different: {
		        	 				field: 'sscyop',
		        	 				message: 'The 12th passyear cannot be the same as ssc Passyear'
		        	 			},
		        	 		}
		        	 	},
		        	 	interpersent:{
		        	 		 err: 'tooltip',
		        	 		validators:{
		        	 			notEmpty:{
		        	 				message:'The 12th persent is required'
		        	 			},
		        	 			regexp: {
		        	 				regexp:/^([1-9]([0-9])?|0)(\.[0-9]{1,2})?$/,
		        	 				message: 'Please give valid percentage'
		        	 			}
		        	 		}
		        	 	},
		        	 	formug:{
		        	 		 err: 'tooltip',
		        	 			validators:{
		        	 				notEmpty:{
		        	 					message:'This field is required'
		        	 				},
		        	 				different: {
		        	 					field: 'inter', 
		        	 					message: ' Invalide Option! select Only Graduation'
		        	 				}
		        	 			}
		        	 	},
		        	 	ugyop:{
		        	 		 err: 'tooltip',
		        	 			validators:{
		        	 				notEmpty:{
		        	 					message:'The graguation passyear is required'
		        	 				},
		        	 				different: {
		        	 					field: 'interyop',
		        	 					message: 'The Gradation passyear cannot be the same as twelth Passyear'
		        	 				},
		        	 			}
		        	 	},
		        	 	ugpersent:{
		        	 		 err: 'tooltip',
		        	 			validators:{
		        	 				notEmpty:{
		        	 					message:'The graguation persent is required'
		        	 				},
		        	 				regexp: {
		        	 					regexp:/^([1-9]([0-9])?|0)(\.[0-9]{1,2})?$/,
		        	 					message: 'Please give valid percentage'
		        	 				}
		        	 			}
		        	 	},
		        	 	formpg:{
			        		 err: 'tooltip',
	        	 			validators:{
	        	 				notEmpty:{
	        	 					message:'This field is required'
	        	 				},
	        	 				different: {
	        	 					field: 'formug',
	        	 					message: 'The PostGraduation cannot be the same as Graduation '
	        	 				},
	        	 			}
	        	 	},
	        	 	pgyop:{
	        	 		 	err: 'tooltip',
	        	 			validators:{
	        	 				notEmpty:{
	        	 					message:'This is required'
	        	 				},
	        	 				different: {
	        	 					field: 'ugyop',
	        	 					message: 'The PostGraduation passyear cannot be the same as Graduation Passyear'
	        	 				},
	        	 			}
	        	 	},
	        	 	pgpersent:{
	        	 		 err: 'tooltip',
	        	 		 	validators:{
	        	 				notEmpty:{
	        	 					message:'This is required'
	        	 				},
	        	 				regexp: {
	        	 					regexp:/^([1-9]([0-9])?|0)(\.[0-9]{1,2})?$/,
	        	 					message: 'Please give valid percentage'
	        	 				}
	        	 		   }
	        	 	  },
		         }
	      });//fieldSetid3
	      
	      $('.registration-form .fieldSetId4') .formValidation({
		    	 framework: 'bootstrap',
		       excluded: ':disabled',
		        icon: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		         row: {
		            valid: 'field-success',
		            invalid: 'field-error'
		         }, 
		         fields: {
		        	 photo: {
		        		 err: 'tooltip',
		        		 validators: {
		        			 notEmpty: {
		        				 message: 'Please select an image having size<2MB'
		        			 },
		        			 file: {
		        				 extension: 'jpeg,jpg,png',
		        				 type: 'image/jpeg,image/png',
		        				 maxSize: 2097152,   // 2048 * 1024
		        				 message: 'The selected file is not valid  because size is morethan 2MB'
		        			 }
		        		 }
		        	 },
		        	 captcha: {
		        		 err: 'tooltip',
		        		 validators: {
		        			 callback: {
		        				 message: 'Wrong answer',
		        				 callback: function(value, validator, $field) {
		        					 var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
		        					 return value == sum;
		        				 }
		        			 }
		        		 }
		        	 }, 
		        	 agree: {
		        		 err: 'tooltip',
		        		 validators: {
		        			 notEmpty: {
		        				 message: 'You must agree with the terms and conditions'
		        			 }
		        		 }
		        	 } 
		         }
	    });//fieldSetId4
     //***********************End Form Field Validation******************************
});//ready()