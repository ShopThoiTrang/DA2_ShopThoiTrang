<%-- 
    Document   : upload
    Created on : 07-Jan-2018, 09:55:06
    Author     : ducna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload</title>
</head>
<body>
    <center>
        <form method="post" action="UploadServlet" enctype="multipart/form-data">
            Select file to upload:
            
            /////////////////////
             <div class="modal-body">
						<div class="form-group">
								<input name="txtMaSPThem" class="form-control"
                                                                       placeholder="Ma sản phẩm ..." type="text" >
							</div>
							<div class="form-group">
								<input name="txtTenSPThem" class="form-control"
									placeholder="Tên sản phẩm ..." type="text" >
							</div>
							
							<div class="form-group">
								<select name="txtLoaiSPThem"  class="form-control">
									
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
									placeholder="Mô tả ..." type="text" >
							</div>
							
						</div>
						<div class="modal-footer">
							<input name="Insert" type="submit" class="btn btn-info" value="Insert">
							<button type="submit" class="btn btn-danger" data-dismiss="modal">Hủy</button>
						</div>
                                                                        ///
                                                                         <input name="txtAnhThemss" class="form-control" placeholder="Ảnh ..." type="text" > 
            <input name="Insert" type="submit" class="btn btn-info" value="Insert">
        </form>
    </center>
</body>
</html>
