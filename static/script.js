$(document).ready(function () {
  $('#upload-form').on('submit', function (e) {
      e.preventDefault();
      var formData = new FormData(this);

      $.ajax({
          type: 'POST',
          url: '/upload',
          data: formData,
          processData: false,
          contentType: false,
          success: function (response) {
              console.log(response);
              loadData();
          },
          error: function (error) {
              console.log(error);
          }
      });
  });

  function loadData() {
      $.get('/data', function (data) {
          $('#data-display').empty();
          data.forEach(function (row) {
              $('#data-display').append(`<p>${row[1]}: ${row[2]}</p>`);
          });
      });
  }
});
