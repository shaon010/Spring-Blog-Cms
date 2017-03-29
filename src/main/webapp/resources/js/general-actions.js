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
                    console.log(resp);
                },
                error: function(xhr, status, error) {
                    var err = eval("(" + xhr.responseText + ")");
                    alert(err.Message);
                }
            })
        }

    })
});
