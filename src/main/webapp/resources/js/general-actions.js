/**
 * Created by Shaon on 3/29/2017.
 */
$(document).ready(function() {
    var categoryDropdown = $(".category-dropdown");
    categoryDropdown.on("click", function () {
        if(categoryDropdown.find("li").length == 0) {
            $.ajax({
                url: "/categoryList",
                dataType: "json",
                success: function (resp) {
                    $.each(resp, function (index, value) {
                        categoryDropdown.find("ul").append("<li><a href='/index/1?categoryId=" + value.id + "' >"+ value.name +  "</a></li>")
                    });
                    categoryDropdown.find("ul")
                },
                error: function(xhr, status, error) {
                    var err = eval("(" + xhr.responseText + ")");
                    alert(err.Message);
                }
            })
        }

    })
});
