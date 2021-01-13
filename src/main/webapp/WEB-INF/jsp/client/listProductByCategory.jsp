<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib  prefix="tag-price" tagdir="/WEB-INF/tags"%>

<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-12 padding-right">
                <div class="features_items"><!--features_items-->
                    <h2 class="title text-center">Features Items</h2>
                    <c:forEach items="${products}" var="product">
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">
                                    <img src="/images/${product.image}" alt=""/>
                                    <tag-price:price price="${product.price}"/>
                                    <p>${product.name}</p>
                                    <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                </div>
                                <div class="product-overlay">
                                    <div class="overlay-content">
                                        <tag-price:price price="${product.price}"/>
                                        <p>${product.name}</p>
                                        <a href="/product-detail/${product.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>
                                </div>
                            </div>
                            <div class="choose">
                                <ul class="nav nav-pills nav-justified">
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div><!--/recommended_items-->
            <ul class="pagination">
                <c:forEach items="1" end="${totalPage}" varStatus="index">
                    <c:choose>
                        <c:when test="${index.index + 1 eq currentPage}">
                            <li class="active"><a href="/category/${currentCategorySlug}?page=${index.index + 1}">${index.index + 1}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="/category/${currentCategorySlug}?page=${index.index + 1}">${index.index + 1}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </ul>
        </div>
    </div>
    </div>
</section>
