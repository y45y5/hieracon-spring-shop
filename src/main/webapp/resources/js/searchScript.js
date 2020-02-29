const searchWithTag = (Tag) => {
    document.getElementById('search').style.color="White";
    document.getElementById('search').value=Tag;
    document.forms[0].submit();
}