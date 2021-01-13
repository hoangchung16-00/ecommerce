<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-9">
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-md-2 border-right">
                    <h4>Category</h4>
                </div>
                <div class="col-md-6">
                    <a href="/admin/add-category" type="button" class="btn btn-sm btn-primary">Add Category</a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover ">
                        <thead class="bg-light ">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Slug</th>
                            <th>Sorting</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${categories}" var="category">
                            <tr>
                                <td><small>${category.id}</small></td>
                                <td><small>${category.name}</small></td>
                                <td><small>${category.slug}</small></td>
                                <td><small>${category.sorting}</small></td>
                                <td>
                                    <a href="/admin/edit-category?categoryId=${category.id}"><i class="fa fa-pencil-square-o"></i></a>
                                    <a href="/admin/delete-category?categoryId=${category.id}"><i class="fa fa-trash"></i></a>
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