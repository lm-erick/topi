$(document).ready(function () {
  $.ajax({
    url: 'https://api.github.com/search/repositories',
    type: 'GET',
    dataType: 'json',
    data: { q: 'language', sort: 'stars', page: '1' },
    success: function (retorno) {
      $.each(retorno.items, function (index, value) {
        $.ajax({
          url: URL_JS + "salvar/"+value.id,
          type: 'POST',
          dataType: 'json',
          data: { id: value.id, avatar: value.owner.avatar_url, name: value.name, score: value.score, forks: value.forks },
          success: function (retorno) {
            console.log('success');
          }
        });
      });
    }
  });

  $.ajax({
    url: URL_JS + "buscar",
    type: 'GET',
    dataType: 'json',
    success: function (retorno) {
      $.each(retorno, function (index, value) {
        $('#recebendoRepositorios').append(
          '<tr>' +
            '<td>' +
              '<img src="' + value.avatar + '">' +
            '</td>' +
            '<td>' + value.name + '</td>' +
            '<td>' + value.stars + '</td>' +
            '<td>' + value.forks + '</td>' +
          '</tr>'
        );
      });
    }
  });
});