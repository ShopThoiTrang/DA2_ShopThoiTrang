/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function checksize(size) {
    if (size == 0)
        alert("giỏ hàng trống");
    else {
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: 'thanhtoan',
            data: {},
            dataType: 'json',
            timeout: 100000,
            success: function (data) { // hàm được thực thi khi request thực hiện
                alert("Thành công");
            },
            error: function (errorThrown) { // hàm được thực thi khi request thất bại
                alert("Lỗi gì đó");
            }
        });
    }
}