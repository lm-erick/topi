$(document).ready(function () {
   $("#searchBar").on('click', '.search', function (event) {
     var language = $("#language").val();
     if(language == "") alert('Please Insert Repository!');
     else{
       $.ajax({
         url: 'https://api.github.com/search/repositories',
         type: 'GET',
         dataType: 'json',
         data: { q: 'language:'+language, sort: 'stars', page: '1' },
         error: function(retorno){
                   alert('Please Insert Correcty Repository!');
                 },
         success: function (retorno) {
           $.each(retorno.items, function (index, value) {
             $.ajax({
               url: URL_JS + "/salvar/" + value.id,
               type: 'POST',
               dataType: 'json',
               data: { id: value.id, avatar: value.owner.avatar_url, name: value.name, stars: value.stargazers_count, forks: value.forks, language: value.language, urlRepository: value.html_url},
               success: function (retorno) {
                 console.log('success');
               }
             });
           });
           atualizarRepositorios(language);
           $("#espacoRepositorios").css("display", "block");
         }
       });
     }
   });
 });

 function atualizarRepositorios(language){
   $.ajax({
     url: URL_JS + "/buscar/"+language,
     type: 'GET',
     dataType: 'json',
     success: function (retorno) {
       $('#recebendoRepositorios tr').remove();
       $.each(retorno, function (index, value) {
         $('#recebendoRepositorios').append(
           '<tr>' +
             '<td>' +
                '<a target= "_blank" href="'+value.urlRepository+'">'+
                    '<img src="' + value.avatar + '">' +
                '</a>'+
             '</td>' +
             '<td>' + value.name + '</td>' +
             '<td>' + value.stars + '</td>' +
             '<td>' + value.forks + '</td>' +
           '</tr>'
         );
       });
     }
   });
 }