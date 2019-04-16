<%-- 
    Document   : IndProducts
    Author     : gkemp
--%>

<div id ="centerColumn">

    <div class ="prodImage">
        <a href="#">
            <span class ="ProdText">Product</span>
        </a>
        <div id="indivProd">
            <p>Product Description ${ProductsBean.description}</p>
             <label class="pad_top">Product Name: </label>
                <input type="hidden" name="Name" value=${ProductsBean.getName} /><br>
                <label class="pad_top">ID: </label>
                <input type="hidden" name="ProductId" value="${ProductsBean.getProductId}" /><br>
                <label class="pad_top">Price: </label>
                <input type="hidden" name="Price" value="${ProductsBean.getPrice}" /><br>
            <span > <button type="submit" class="btn" 
                            name="Add to Cart" value="${ProductsBean.productId}"> Add To Cart</button></span>
        </div>
    </div>  
</div>
