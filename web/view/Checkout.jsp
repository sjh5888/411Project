<%-- 
    Document   : Checkout
    Author     : gkemp
--%>

<div id ="centerColumn">
    <h1>Checkout</h1>
    <form method ="post" action="${initParam['posturl']}">
    <input type="hidden" name="upload" value="1" />
    <input type="hidden" name="return" value="${initParam['returnurl']}" />
    <input type="hidden" name="cmd" value="_ShoppingCart" />
    <input type="hidden" name="business" value="${initParam['business']}"/>
    
    <input type="hidden" name="Name" value="1" />
    <input type="hidden" name="ProductId" value="p1" />
    <input type="hidden" name="Price" value="2" />
    <input type="hidden" name="business" value="3"/>
    </form>
</div>