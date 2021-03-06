# spring-study-groups
Spring(特にSpring MVC)を使ったアプリケーション開発向けの勉強会ページです。

## 対象者

以下を対象者として想定していますが、基本的には誰でも歓迎します。

* Java、Servlet、JSP、DI(Dependency Injection)、AOP(Aspect Oriented Programming)などの基本知識がある人
* Spring MVCを使ったWebアプリケーション開発の経験がない人

## 教材

[TERASOLUNA Server Framework for Java (5.x) Development Guideline](http://terasolunaorg.github.io/guideline/) を使います。

TERASOLUNA独自の考え方なども含まれていますが、Spring MVCを使ったWebアプリケーション開発に必要な基本的な知識を一通り得ることができます。

なお、TERASOLUNA Server Framework for Java (5.x)のガイドラインは、Java ConfigによるBean定義やSpring Bootに対応していません。
Java ConfigやSpring Bootを使って開発したい方は、創作課題を作成する際に採用してみてください。

## 進め方

勉強会と銘打っていますが、基本的にはこちらから特別なアクションを起こすことはありません。
TERASOLUNA Server Framework for Java (5.x)のガイドラインベースに各自勉強してもらって、わからないところは[Issue](https://github.com/kazuki43zoo/spring-study-groups/issues/new)を発行して質問してください。ベストエフォートで回答します。

まず、[Springの理解度チェック](http://terasolunaorg.github.io/guideline/5.1.0.RELEASE/ja/Appendix/SpringComprehensionCheck.html)を実施し、Issueで回答をください。目的は現状の理解度の把握なので、ドーピング（こっそり調べて回答）はしないでください。わからなくても恥ずかしくありません！！（この時点では、回答は教えませんw -> 創作課題終了後にもう１度理解度チェックをしてもらいます）

進め方に規定は設けませんが、何から手をつけたらよいかわからない人は、

* 各種チュートリアルを実施し、Springを使ったアプリケーション開発を体験（体感）する。
* 「TERASOLUNA Server Framework for Java (5.x)のアーキテクチャ概要」を読み、アーキテクチャの概要を理解する。
* 「TERASOLUNA Server Framework for Java (5.x)によるアプリケーション開発」を読み、開発方法を理解する。特に、「アプリケーション層の実装」の章を読むとSpring MVCの使い方が学べます。

という流れで勉強するのがよいと思います。

上の３つが終わったら、創作課題として、標準的なCRUD機能を提供する「ユーザー管理システム」を開発しながら「TERASOLUNA Server Framework for Java (5.x)の機能詳細」「TERASOLUNA Server Framework for Java (5.x)によるセキュリティ対策」に記載されている内容を理解しましょう。
また、「TERASOLUNA Server Framework for Java (5.x)の機能詳細」「TERASOLUNA Server Framework for Java (5.x)によるセキュリティ対策」では、Springに直接依存しない一般的な開発ノウハウも数多く紹介しています。

「ユーザー管理システム」の基本的な要件と仕様は提示するので、各自工夫してアプリケーションを作ってみてください。
なお、要件や仕様は変更しても問題ありません。
「ユーザー管理システム」だと物足りない人は、自分で題材を考えて、アプリケーションを創作してください。

## 各種チュートリアルの実施について

以下のチュートリアルが用意されています。すべて実施するのがお勧めです。

* [はじめてのSpring MVCアプリケーション](http://terasolunaorg.github.io/guideline/5.1.0.RELEASE/ja/Overview/FirstApplication.html)
* [チュートリアル(Todoアプリケーション)](http://terasolunaorg.github.io/guideline/5.1.0.RELEASE/ja/TutorialTodo/index.html)
* [チュートリアル(Todoアプリケーション REST編)](http://terasolunaorg.github.io/guideline/5.1.0.RELEASE/ja/TutorialREST/index.html)
* [Spring Securityチュートリアル](http://terasolunaorg.github.io/guideline/5.1.0.RELEASE/ja/Security/Tutorial.html)

## 創作課題「ユーザー管理システム」の要件

最低限、以下の項目をユーザ情報としてDBで管理する。

* ログインID
* 氏名
* 誕生日
* 電話番号
* E-Mail
* パスワード (ハッシュ化後のパスワード)
* ロール(管理ユーザ or 一般ユーザ)

最低限、以下の機能を提供する。

* ユーザ登録機能
* ユーザ検索機能
* ユーザ詳細表示機能
* ユーザ変更機能
* ユーザ削除機能
* パスワード変更機能

システムの利用者は、「管理ユーザ」と「一般ユーザ」の２種類として、以下の認可制御を行う。

* ユーザ登録機能は誰でも利用可能で、それ以外の機能はログインが必要
* ログイン後に一般ユーザが利用できるのは「ユーザ変更機能」のみ（操作できるのはログインユーザの情報のみ）
* 匿名ユーザが登録できるのは「一般ユーザ」のみで、管理ユーザは「管理ユーザ」の作成が可能

最低限、以下のセキュリティ要件を充す。

* 管理ユーザが作成したユーザは、初回ログイン時にパスワードの変更が必要
* パスワードには有効期限を設け、期限切れの場合はパスワードの変更が必要

アプリケーションの作りとしては、以下をみたす。

* メッセージはプロパティファイルから取得する
* 設定値はプロパティファイルから取得する
* 検索機能ではページングをサポートする

アプリケーションの種類は、伝統的な画面遷移型のWebアプリケーションでもよいですし、
SPA(Single Page Application)に代表されるモダンでリッチなWebアプリケーションでもよいです！！
ま〜ユーザ管理だとリッチなUIは必要ないと思いますが・・・。

## 成果物の管理について

チュートリアルや創作課題で作成した成果物は、すべて本リポジトリで管理します。
成果物を作成する際は、以下の手順に従ってください。

* 成果物を作成するためのIssueを作成する
* Issue対応用のブランチ(`issues/xx_short-description`)で対応する
* アカウント名のディレクトリの中に、プロジェクトを作成する
* チュートリアルは、完成した際にPull Requestする。
* 創作課題は適度な単位でPull Requestする。その祭、工夫した点などをコメントに記載してください (機能毎のPull Requestを歓迎します)
* 気になる点などコメントするので、ブラッシュアップしながら理解を深めましょう
