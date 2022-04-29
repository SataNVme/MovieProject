function getSearchList() {
	$.ajax({
			type : 'GET',
			url : "/search/getSearchList",
			data : $("form[name=search-form]").serialize(),
			success : function(result) {
				// 테이블 초기화
				console.log(result);
				$('#movietable > tbody').empty();
				if(result.length >= 1) {
					result.forEach(function(item) {
						str = "<tr>"
						str += "<td>" + item.movie_iUrl + "</td>";
						str += "<td><a href='/search/getSearchList?movie_iUrl=" + item.movie_iUrl + "'>" + item.movie_nm + "</a></td>";
						str += "<td>" + item.movie_dirNm + "</td>";
						str += "<td>" + item.movie_actNm + "</td>";
						str += "<td>" + item.movie_apiRt + "</td>";
						str += "<td>" + item.movie_ov + "</td>";
						str += "</tr>"
						$('#movietable').append(str);
					});
				}
			}
		});
	}
// 검색 버튼
	var searchBtn = document.getElementById("searchBtn");
	searchBtn.onclick = function() {
		event.preventDefault(); // a의 기본 이벤트 중지
		document.getSearchList.submit(); // 폼 전송
	}	