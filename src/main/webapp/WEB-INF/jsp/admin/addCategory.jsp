<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="row">
    <div class="col-md-12 col-md-offset-10">
        <form:form class="form-horizontal" role="form" method="post" action="/admin/add-category" modelAttribute="addCategoryForm">
            <fieldset>
                <!-- Form Name -->
                <legend>Add Category</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-sm-2 control-label">Category Name</label>
                    <div class="col-sm-10">
                        <form:input path="name" placeholder="Category Name" class="form-control"/>
                        <form:errors path="name"/>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-sm-2 control-label">Category Sorting</label>
                    <div class="col-sm-10">
                        <form:input path="sorting" placeholder="Category Sorting" class="form-control"/>
                        <form:errors path="sorting" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="pull-right">
                            <button type="submit" class="btn btn-default">Cancel</button>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </div>

            </fieldset>
        </form:form>
    </div><!-- /.col-lg-12 -->
</div><!-- /.row -->