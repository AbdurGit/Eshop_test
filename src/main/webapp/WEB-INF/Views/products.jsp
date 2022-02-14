<jsp:include page="header.jsp" />
<style>
.product{

}
.wrap{
box-shadow: 0px 2px 10px #ddd;
padding-left: 20px;
padding-right: 20px;
margin-bottom:10px;


}
.wrap:hover{

box-shadow: 0px 2px 20px #ccc;}

/* .singlePdtWrap{
border:1px solid #ddd;

} */
.singlePdt,.pdtSpec{
border:1px solid #eee;
}
.pdt_mrp{
color:red;
font-size:25px;
}






</style>
 <script type="text/javascript">


$( document ).ready(function() {
    console.log( "ready!" );
    var base_url="http://localhost:8080/Eshop/";
    var full_url=base_url+"getProducts";
    	  $.ajax({
    		  url: full_url,
    		  type:"GET",
    		  dataType:"json",
    		  beforeSend: function(){
    			 
    			    $('.loader').show();
    			  },
    		  success: function(result){
    			  console.log(result);
    			  var htmlouter="<p>this id being added inside</p>";
    			  for(var i=0;i<result.length;i++){
    				  var product_name=result[i].productName;
    				  var product_brand=result[i].brand;
    				  var product_id=result[i].productId;
    				  var product_spec=result[i].specification;
    				  var product_mrp=result[i].price.mrp;
    				  var html="<div class=\"product col-md-3\"><div class=\"wrap\"><a class=\"productLink\" id=\""+product_id+"\" href=\"javaScript:void(0)\">"
    				  
    				 +"<img class=\"img-responsive\" src=\"resources/images/pdt_thumb.jpg\">"
    				  +"<div class=\"pdtName\">"+product_name+"</div><div class=\"pdtBrand\">"+product_brand+"</div>"
    				  +"<div class=\"pdtspec\">"+product_spec+"</div>"
    				  +"<div class=\"pdtmrp\">&#x20B9;"+product_mrp+"</div>"
    				  +"</a></div></div>";
    				  htmlouter=htmlouter+html;
    			  } 
    			  $(".products").html(htmlouter);
    			  
    			  
    			  
    	   
    	  },
    	  complete: function(){
    		  $('.loader').hide();
    		  },
    	  error: function (error) {
    		  $('.loader').hide();
    		    console.log('error; ' + eval(error));
    		}});
   
      $(".productLink").click(function(){
    		  alert("link Clicked");
    		  var id=this.attr("id");
    		  getProduct(id);
    	});
      
      $(document).on('click', '.productLink', function() {
    	  var id=$(this).attr("id");
    	
    	  getProduct(id);
    	  
    	  
    	  
    	 });
     /*  $(".abc").click(function(){
    		  alert("link Clicked");
    		 
    	}); */
    	  
      
    	  
    	  
    	 function getProduct(id){
    		  var base_url="http://localhost:8080/Eshop/";
    		    var full_url=base_url+"getProduct";
    		  $.ajax({
    			  url: full_url,
    			  type:"GET",
    			  dataType:"json",
    			  data:{
    				  "id":id
    			  },
    			  beforeSend: function(){
    	    			 
      			    $('.loader').show();
      			  },
    			  success: function(result){
    				 
    				
    				  var html="<div class=\"col-md-4 \"><div class=\"col-md-12 singlePdt\">"
    				+"<img class=\"img-responsive\" src=\"resources/images/pdtImg.jpg\">"
    				  +"<div>"+result.productName+"</div>"
    				  +"<div>"+result.brand+"</div>"
    				  +"<div class=\"col-md-12\" style=\"text-align:center;\"><button style=\"margin:10px;\" type=\"button\" class=\"btn btn-primary\">Add to Cart</button><button  style=\"margin:10px;\" type=\"button\" class=\"btn btn-warning\">Buy Now</button></div>"
    				  +"</div></div>";
    				  var specHtml="<div class=\"col-md-6 \"><div class=\"col-md-12 pdtSpec\">"
    					  +"<h3>"+result.productName+"</h3>"
    					  +"<h5>"+result.brand+"</h5>"
    					  +"<div>"+result.specification+"</div>"
    					  +"<div class=\"pdt_mrp\">&#x20B9;"+result.price.mrp+"</div>"
    				  +"</div></div>";
    				  html=html+specHtml;
    				  $(".singlePdtWrap").show(100).html(html);
    				  
    				  $(".products").hide(100);
    				 
    				 
    				  
    				  
    				  
    		   
    		  },
    		  complete: function(){
        		  $('.loader').hide();
        		  },
    		  error: function (error) {
    			  $('.loader').hide();
    			    console.log('error; ' + eval(error));
    			}});
    		  
    		  
    	} 

    	   
    	  
    	  
});




</script>




<div class="products container"></div>

<div class="singlePdtWrap container" style="display: none;"></div>


</body>
</html>


