
//封装ajax_get请求
var ajax_get = function (url, data, success, error) {
    var option = {
        async: true,
        // contentType:"application/x-www-form-urlencoded",
        data: data,
        dataType: "json",
        success: success,
        error: error,
        url: url,
        type: "get"
    };
    $.ajax(option)
}
//封装ajax_post请求
var ajax_post = function (url, data, success, error) {
        var option = {
            async: true,
            // contentType: "application/json",
            data: data,
            // data: JSON.stringify(data),
            dataType: "json",
            success: success,
            error: error,
            url: url,
            type: "post"
        };
        $.ajax(option)
    }
