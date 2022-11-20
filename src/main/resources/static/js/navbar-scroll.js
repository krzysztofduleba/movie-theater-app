function changePaddingOnScroll() {
    if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
        document.getElementById("header-navbar").classList.add("py-0");
    } else {
        document.getElementById("header-navbar").classList.remove("py-0");
    }
}

window.onscroll = function() {
    changePaddingOnScroll()
};