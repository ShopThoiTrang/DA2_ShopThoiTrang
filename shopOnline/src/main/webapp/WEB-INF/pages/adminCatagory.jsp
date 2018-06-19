
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/prettyPhoto.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/price-range.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/responsive.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/gmaps.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/html5shiv.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery.prettyPhoto.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery.scrollUp.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/price-range.js"/>" type="text/javascript"></script>
        <title>Sản phẩm</title>
        <script type="text/javascript">
            function clickcheckThem() {
                if (document.getElementById("checkThem").checked == true)
                    document.getElementById("txtIsShowThem").value = 'True'
                else
                    document.getElementById("txtIsShowThem").value = 'False'
            }
            function clickcheckSua() {
                if (document.getElementById("checkSua").checked == true)
                    document.getElementById("txtIsShowSua").value = 'True'
                else
                    document.getElementById("txtIsShowSua").value = 'False'
            }
            function selectedRowDelete(row_id) {
                document.getElementById('row_id').value = row_id;
            }
        </script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container">
                <!--<form role="form" action="product" method="post" enctype="multipart/form-data">-->

                <br><br><br><br>
                <div class="row">
                    <div class="col-lg-1">

                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalThem" >Thêm</button>

                    </div>
                    <div class="col-lg-11 pull-right">
                        <div class="input-group col-md-6">
                            <form action="search" method="post">
                                <input name="tenSPSearch" type="text" class="form-control"	placeholder="Product Name" /> 
                                <span class="input-group-btn">
                                    <input type="submit" class="btn btn-info btn-md" name = "search" value="search">
                                </span>
                            </form>
                        </div>
                    </div>
                </div>
                <br> <br>
                <table class="table table-bordered">
                    <thead>
                        <tr class="info">
                            <th class="text-center">Mã SP</th>
                            <th class="text-center">Tên SP</th>
                            <th class="text-center">Đơn giá</th>
                            <th class="text-center">Ảnh </th>
                            <th class="text-center">Mô tả</th>
                            <th class="text-center ">Sửa</th>
                            <th class="text-center ">Xóa</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="sanpham" items="${listPD}">
                        <tr>
                            <td>${sanpham.productID}</td>
                            <td>${sanpham.productName}</td>
                            <td>
                                ${sanpham.productPrice}
                            </td>
                            <td><img alt="Ảnh" src= "<c:url value="/resources/images/shop/${sanpham.productImage}" />" style="width: 120px; height: 120px"> </td>
                            <td>${sanpham.productDescription}</td>

                            <td class="text-center">
                                <input type="button" class="btn btn-info" 
                                       data-toggle="modal" data-target="#myModalSua"
                                       data-masp="${sanpham.productID }" 
                                       data-tensp="${sanpham.productName }" 
                                       data-tenloaisp="${sanpham.category.categoryID}" 
                                       data-gia="${sanpham.productPrice }" 
                                       data-anh1="${sanpham.productImage }" 
                                       data-mota="${sanpham.productDescription }" 
                                       value="Sửa">
                            </td>
                            <td class="text-center">
                                <input type="button" class="btn btn-danger"
                                       data-toggle="modal" data-target="#myModalXoa"
                                       data-masp="${sanpham.productID }" 
                                       onclick="selectedRowDelete('${sanpham.productID}')" 
                                       value="Xóa">
                            </td>
                        </tr> 
                    </c:forEach>
                </tbody>
            </table>

            <!-- Modal thêm sản phẩm-->
            <form:form method="POST" action="themsanpham" enctype="multipart/form-data">
                <div class="modal fade" id="myModalThem" role="dialog">
                    <div class="modal-dialog">
                        <!--  <form action="addss" enctype="multipart/form-data" method="post" >-->
                        <!-- Modal content-->
                        <div class="modal-content">

                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="pannel-header">Thêm sản phẩm</h4>
                            </div>

                            <div class="modal-body">
                                <div class="form-group">
                                    <input name="txtTenSPThem" class="form-control"
                                           placeholder="Tên sản phẩm ..." type="text" >
                                </div>

                                <div class="form-group">
                                    <select name="txtLoaiSPThem"  class="form-control">
                                        <c:forEach var="l" items="${listCate}">
                                            <option value="${l.categoryID}">${l.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input name="txtDonGiaThem" class="form-control"
                                           placeholder="Đơn giá ..." type="number" >
                                </div>
                                <div class="form-group">
                                    <input name="txtAnhThem" class="form-control" placeholder="Ảnh ..." type="file" accept="image/*"> 

                                </div>
                                <div class="form-group">
                                    <input name="txtMoTaThem" class="form-control"
                                           placeholder="Mô tả ..." type="text" />
                                </div>

                            </div>
                            <div class="modal-footer">
                                <input name="Insert" type="submit" class="btn btn-info" value="Insert">
                                <button type="submit" class="btn btn-danger" data-dismiss="modal">Hủy</button>
                            </div>
                        </div>

                    </div>
                </div>
            </form:form>


            <!-- Modal sửa sản phẩm-->
            <form action="suasanpham" method="post" enctype="multipart/form-data" >
                <div class="modal fade" id="myModalSua" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4>Sửa mặt hàng</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <input type="text" name="txtMaSPSua" id="masanpham" class="form-control"
                                           placeholder="Mã sản phẩm ..." readonly="readonly"/>
                                </div>
                                <div class="form-group">
                                    <input name="txtTenSPSua" id="tensanpham" class="form-control"
                                           placeholder="Tên sản phẩm ..." type="text">
                                </div>

                                <div class="form-group">
                                    <select name="txtLoaiSPSua" id="maloaisanpham"  class="form-control">
                                        <c:forEach var="l" items="${listCate}">
                                            <option value="${l.categoryID}">${l.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input name="txtDonGiaSua" id="dongia" class="form-control"
                                           placeholder="Đơn giá ..." type="number" >
                                </div>
                                <div class="form-group">
                                    <input name="txtAnhSua" id="anh" class="form-control"
                                           placeholder="Ảnh ..." type="file" accept="image/*" >
                                    <input type="hidden" id="txtAnh" name="txtAnh">
                                    <input type="hidden" id="txtClickAnh" name="txtClickAnh">
                                </div>

                                <div class="form-group">
                                    <input name="txtMoTaSua" id="mota" class="form-control"
                                           placeholder="Mô tả ..." type="text" >
                                </div>

                            </div>
                            <div class="modal-footer">
                                <input name="Edit" id="sua" type="submit" class="btn btn-info" value="Edit">
                                <button type="submit" class="btn btn-danger"
                                        data-dismiss="modal">Hủy</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <!-- Modal xóa sản phẩm-->
            <div class="modal fade" id="myModalXoa" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <form action="Deleteproduct" method="post">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4>Xóa mặt hàng</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <input type="hidden" id="row_id" name="txtMaSPXoa" /> 
                                    <h5 class="modal-title"></h5>     
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input name="Delete" type="submit" class="btn btn-danger" value="Delete">
                                <button type="submit" class="btn btn-info"
                                        data-dismiss="modal">Hủy</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!--</form>-->
        </div>

        <script>
            $('#myModalThem').on('show.bs.modal', function (event)
            {});

            $('#myModalSua').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget) // Button that triggered the modal
                var msp = button.data('masp')
                var tsp = button.data('tensp')
                var mtg = button.data('tentg')
                var lsp = button.data('tenloaisp')
                var mt = button.data('mota')
                var a = button.data('anh')
                var dg = button.data('gia')



// Extract info from data-* attributes
                // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
                // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
                var modal = $(this)
                modal.find('.modal-body input#masanpham').val(msp)
                modal.find('.modal-body input#tensanpham').val(tsp)
                modal.find('.modal-body select#maloaisanpham').val(lsp)
                modal.find('.modal-body input#mota').val(mt)
                modal.find('.modal-body input#dongia').val(dg)
                modal.find('.modal-body input#anh').val(a)
                modal.find('.modal-body input#txtAnh').val(a1)
            });
            $('#myModalXoa').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget) // Button that triggered the modal
                var msp = button.data('masp')

//Extract info from data-* attributes
                // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
                // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
                var modal = $(this)
                //alert(msp)
                modal.find('.modal-title').text('Bạn có muốn xóa sản phẩm "' + msp + '" không?')
            });
            $("#sua").click(function () { // bCheck is a input type button
                var fileName = $("#anh").val();
                if (fileName) { // returns true if the string is not empty
                    document.getElementById("txtClickAnh").value = 'True'
                } else { // no file was selected
                    document.getElementById("txtClickAnh").value = 'False'
                }
            });

        </script>
        <br>
        <br>
        <br>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>