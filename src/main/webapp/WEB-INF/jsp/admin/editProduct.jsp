<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="row">
    <div class="col-md-12 col-md-offset-10">
        <form:form class="form-horizontal" role="form" method="post" action="/admin/edit-product" modelAttribute="productForm" enctype="multipart/form-data">
            <fieldset>

                <!-- Form Name -->
                <legend>Edit Product</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-sm-2 control-label">Product Name</label>
                    <form:hidden path="id"/>
                    <div class="col-sm-10">
                        <form:input path="name" placeholder="Product Name" class="form-control"/>
                        <form:errors path="name"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Category Name</label>
                    <div class="col-sm-10">
                        <form:select path="categoryId" items="${categories}" itemLabel="name" itemValue="id" class="form-control">
                            <form:option value="id"/>
                        </form:select>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-sm-2 control-label">Description</label>
                    <div class="col-sm-10">
                        <form:input path="description" placeholder="Description" class="form-control"/>
                        <form:errors path="description"/>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-sm-2 control-label">Quantity</label>
                    <div class="col-sm-10">
                        <form:input path="quantity" placeholder="Quantity" class="form-control"/>
                        <form:errors path="quantity"/>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-sm-2 control-label">Price</label>
                    <div class="col-sm-10">
                        <form:input path="price" placeholder="Price" class="form-control"/>
                        <form:errors path="price"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Image</label>
                    <div class="col-sm-10">
                        <input type="file" name="productImage" value="/images/${imageName}" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="pull-right">
                            <button href="#" type="button" class="btn btn-default">Cancel</button>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </div>

            </fieldset>
        </form:form>
    </div><!-- /.col-lg-12 -->
</div><!-- /.row -->