$(document).ready(function(){
    $.get('/data', {}, function(data){
        console.log(data);
        var i = 0;
        $.each(data, function(key, value){
            var nav_tab_element = $($('#nav-tab-template').html());
            if(i == 0){
                nav_tab_element.addClass('active');
            }
            nav_tab_element.find("a").attr('href', '#'+key);
            nav_tab_element.find(".nav-tab-icon i").addClass('fa-'+key);
            nav_tab_element.find(".nav-tab-text").html(key);
            $('#nav_menu').append(nav_tab_element);

            var nav_pane_element = $($('#tab-pane-template').html());
            if(i == 0){
                nav_pane_element.addClass('active').addClass('in');
            }
            nav_pane_element.attr('id', key);
            for(var j in value){
                var item = value[j];
                nav_pane_element.append('<p>'+item['name_en']+','+item['name_cn']+'</p>');
            }
            $('#myTabContent').append(nav_pane_element);
            i++;
        });
    });
});