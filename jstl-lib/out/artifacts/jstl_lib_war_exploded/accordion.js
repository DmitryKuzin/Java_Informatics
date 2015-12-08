/**
 * Created by kuzin on 30.10.2015.
 */
(function($) {

    var allPanels = $('.accordion > dd').hide();

    $('.accordion > dt > a').click(function() {
        allPanels.slideUp();
        $(this).parent().next().slideDown();

        return false;
    });

})(jQuery);