<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li class="active">Shopping Cart</li>
            </ol>
        </div>
        <h1 id="test">Before</h1>
            <c:choose>
                <c:when test="${cart==null || empty cart.cartItems}">
                    Cart is empty
                </c:when>
                <c:otherwise>
                    <div class="table-responsive cart_info">
                        <table class="table table-condensed" id="tblCart">
                            <thead>
                            <tr class="cart_menu">
                                <td class="image">Item</td>
                                <td class="description"></td>
                                <td class="price">Price</td>
                                <td class="quantity">Quantity</td>
                                <td class="total">Total</td>
                                <td></td>
                            </tr>
                            </thead>
                            <tbody id="tbody">
                            <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="index">
                                <tr>
                                    <td class="cart_product">
                                        <a href=""><img width="128" height="128" src="/images/${cartItem.product.image}" alt=""></a>
                                    </td>
                                    <td class="cart_description">
                                        <h4><a href="">Colorblock Scuba</a></h4>
                                        <p>${cartItem.product.id}</p>
                                        <input type="hidden" value="${cartItem.product.id}">
                                    </td>

                                    <td class="cart_price">
                                        <p>${cartItem.product.price}</p>
                                    </td>
                                    <td class="cart_quantity">
                                        <div class="cart_quantity_button">
                                            <a class="cart_quantity_up" href=""> + </a>
                                            <input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
                                            <a class="cart_quantity_down" href=""> - </a>
                                        </div>
                                    </td>
                                    <td class="cart_total">
                                        <p class="cart_total_price">$59</p>
                                    </td>
                                    <td class="cart_delete">
                                        <input type="button" value="Submit"  id="remove" class="cart_quantity_delete" onclick="removeCartItem(${cartItem.product.id});deleteRow(this);"><i class="fa fa-times" ></i></input>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:otherwise>
            </c:choose>
    </div>

<section id="do_action">
    <div class="container">
        <div class="heading">
            <h3>What would you like to do next?</h3>
            <p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="chose_area">
                    <ul class="user_option">
                        <li>
                            <input type="checkbox">
                            <label>Use Coupon Code</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label>Use Gift Voucher</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label>Estimate Shipping & Taxes</label>
                        </li>
                    </ul>
                    <ul class="user_info">
                        <li class="single_field">
                            <label>Country:</label>
                            <select>
                                <option>United States</option>
                                <option>Bangladesh</option>
                                <option>UK</option>
                                <option>India</option>
                                <option>Pakistan</option>
                                <option>Ucrane</option>
                                <option>Canada</option>
                                <option>Dubai</option>
                            </select>

                        </li>
                        <li class="single_field">
                            <label>Region / State:</label>
                            <select>
                                <option>Select</option>
                                <option>Dhaka</option>
                                <option>London</option>
                                <option>Dillih</option>
                                <option>Lahore</option>
                                <option>Alaska</option>
                                <option>Canada</option>
                                <option>Dubai</option>
                            </select>

                        </li>
                        <li class="single_field zip-field">
                            <label>Zip Code:</label>
                            <input type="text">
                        </li>
                    </ul>
                    <a class="btn btn-default update" href="">Get Quotes</a>
                    <a class="btn btn-default check_out" href="">Continue</a>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="total_area">
                    <ul>
                        <li>Cart Sub Total <span>$59</span></li>
                        <li>Eco Tax <span>$2</span></li>
                        <li>Shipping Cost <span>Free</span></li>
                        <li>Total <span>$61</span></li>
                    </ul>
                    <a class="btn btn-default update" href="">Update</a>
                    <a class="btn btn-default check_out" href="">Check Out</a>
                </div>
            </div>
        </div>
    </div>
</section><!--/#do_action-->
    <script type="text/javascript">
        function removeCartItem(i) {
            var productId=i;
            $.ajax({
                type: "GET",
                contentType:"application/json",
                url: "/removeCartItem",
                data: {
                    productId : productId
                },
                timeout:100000,
                success: function (data) {
                    console.log("SUCCCESS: ",data);
                },
                error: function (e) {
                    console.log("ERROR: ",e);
                }
            });

        }
        function deleteRow(r) {
            var i = r.parentNode.parentNode.rowIndex;
            document.getElementById("tblCart").deleteRow(i);
        }
    </script>
