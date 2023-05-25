# 第10回課題　MyBatisでのCRUD処理の実装  
## 歴代アニメ映画の興行収入の高いものをデータベースにしました。

## 実装内容  
#### ・"/animeMovies/All"でanimeMoviesテーブルの一覧が返ってくる。  
#### ・"/animeMovies/publishedYear?publishedYear=YYYY"で、publishedYearの一致するレコード一覧が返ってくる。
#### ・"/animeMovies/id?id=XX"で、idの一致するレコードが返ってくる。
#### ・POST,PATCH,DELETEリクエストの実装完了。
#### ・CustomExceptionHandler作成。BadRequest時、ResourceNotFoundExceptionに対応。

## Postmanでの動作確認結果

### /animeMovies/Allの実行結果
<img width="1470" alt="スクリーンショット 2023-05-26 0 54 54" src="https://github.com/OOTSUJIYUUSUKE/test09/assets/129093155/fd440ea4-c3d3-4bb3-b7fa-aba532dfbf61">

### /animeMovies/id?id=1０の実行結果
<img width="1470" alt="スクリーンショット 2023-05-26 0 55 10" src="https://github.com/OOTSUJIYUUSUKE/test09/assets/129093155/0274baea-4a01-47f6-8de0-4640efeb2206">

### /animeMovies/publishedYear?publishedYear=2012の実行結果
<img width="1470" alt="スクリーンショット 2023-05-26 0 55 32" src="https://github.com/OOTSUJIYUUSUKE/test09/assets/129093155/efefdb6e-bad9-4309-9cad-b0a090e92c4e">

### POSTリクエスト
<img width="1470" alt="スクリーンショット 2023-05-26 0 56 11" src="https://github.com/OOTSUJIYUUSUKE/test09/assets/129093155/f71a43e6-d52e-490c-9a73-1bb89f076374">

### PATCHリクエスト
<img width="1470" alt="スクリーンショット 2023-05-26 0 56 33" src="https://github.com/OOTSUJIYUUSUKE/test09/assets/129093155/df581e60-59ca-425f-bf4b-b8e6ef73fd3f">

### DELETEリクエスト
<img width="1470" alt="スクリーンショット 2023-05-26 0 56 49" src="https://github.com/OOTSUJIYUUSUKE/test09/assets/129093155/79869134-518b-44bc-be2a-3d1b7f99bf1d">

### ResourceNotFoundException発生時
<img width="1470" alt="スクリーンショット 2023-05-26 0 57 11" src="https://github.com/OOTSUJIYUUSUKE/test09/assets/129093155/1f909997-b4e9-468e-b81b-35acc7b159d5">

### BadRequest発生時
<img width="1470" alt="スクリーンショット 2023-05-26 0 57 22" src="https://github.com/OOTSUJIYUUSUKE/test09/assets/129093155/4490858a-91b5-43c7-aa1d-9b36a3e4bcea">


