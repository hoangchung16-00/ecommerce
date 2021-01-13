<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-9">
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-md-2 border-right">
                    <h4>Product</h4>
                </div>
                <div class="col-md-6">
                    <a href="/admin/add-product" type="button" class="btn btn-sm btn-primary">Add Product</a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover ">
                        <thead class="bg-light ">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Category</th>
                            <th>Description</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Image</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${products}" var="product">
                            <tr>
                                <td><small>${product.id}</small></td>
                                <td><small>${product.name}</small></td>
                                <td><small>${product.categoryName}</small></td>
                                <td><small>${product.description}</small></td>
                                <td><small>${product.quantity}</small></td>
                                <td><small>${product.price}</small></td>
                                <td><img src="/images/${product.image}" height="30px" width="50px"></td>
                                <td>
                                    <a href="/admin/edit-product?productId=${product.id}"><i class="fa fa-pencil-square-o"></i></a>
                                    <a href="/admin/delete-product?productId=${product.id}"><i class="fa fa-trash"></i></a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
