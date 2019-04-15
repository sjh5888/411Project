<%-- 
    Document   : IndProducts
    Author     : gkemp
--%>

<div id ="indexCenterColumn">

    <div class ="prodImage">
        <a href="#">
            <span class ="ProdText">Product</span>
        </a>
        <div id="indivProd">
            <p>Product Description ${ProductsBean.getDescription}</p>
            <span > <button type="submit" class="btn btn-default" 
                            name="Add to Cart" value="${ProductsBean.getProductId}"> Add To Cart</button></span>
        </div>
    </div>  
</div>
