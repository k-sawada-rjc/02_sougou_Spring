package com.example.util;

/**
 * SQLUtilクラス
 * このクラスを使用してSQLを実行する
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.sql.SQLException;

/**
 * ■　SqlUtilの解説。■<br>
 * publicメソッドは六つ（うち一つはstatic）。<br>
 * 唯一のConnectionをフィールドとして持ったオブジェクトをgetInstanceで返す。<br>
 * <br>
 * 　　インスタンスを生成する方法<br>
 * 　　　・これは出来ない　⇒　SqlUtil s = new SqlUtil();<br>
 * 　　　・これで生成する　⇒　SqlUtil s = SqlUtil.getInstance("ユーザー","パスワード");<br>
 * 　　　　※　唯一のインスタンスを返すようにする方法をSingletonという<br>
 * <br>
 * 以降、executeSelectでSQL文を引数に渡すとSQLを実行しResultSetを返す。<br>
 * また、executeUpdateでSQL文を引数に渡すとSQLを実行し、intを返す<br>
 * 任意の箇所で、commit、rollbackを呼び、最後にcloseAllで全てを開放する。<br>
 * <br>
 *	 注意：最後にかならずcloseAllを呼んでリソースを開放すること。<br>
 *
 * RJC Human Resource
 */
public class SqlUtil {

	private static SqlUtil g = null;
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/**
	 * コンストラクタ（処理なし）
	 * インスタンスが生成出来ないようにする為にprivateにする
	 */
	private SqlUtil () {
		//処理なし
	}

	/**
	 * コネクション設定
	 * このメソッドを最初に必ず呼ぶこと
	 *
	 * @param user データベース接続ユーザー
	 * @param password データベース接続パスワード
	 * @return SqlUtil
	 * @throws SQLException コネクション取得を失敗したとき
	 */
	public static SqlUtil getInstance(String user, String password) throws SQLException   {
		//SqlUtilがnullの場合ｲﾝｽﾀﾝｽ生成
		if(g==null) {
			g = new SqlUtil();
		}

		try {
			//コネクションを取得する
			g.setConn(user,password);
		} catch (ClassNotFoundException e) {
			// クラスが見つからない場合は続行不可能のため、RuntimeExceptionにしてダンプ
			System.out.println("致命的なエラーが発生しました。");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return g;
	}

	/**
	 * コネクション取得
	 *
	 * @param user データベース接続ユーザー
	 * @param password データベース接続パスワード
	 * @return コネクション
	 * @throws ClassNotFoundException ドライバクラスが見つからないとき
	 * @throws SQLException コネクション取得を失敗したとき
	 */
	private void setConn(String user,String password) throws ClassNotFoundException, SQLException {

		//ドライバーをロード
		Class.forName("org.postgresql.Driver");
		//url
		String url = "jdbc:postgresql://localhost:5432/training";

		//コネクションを取得
		conn = DriverManager.getConnection(url,user,password);

		//オートコミットをオフにする
		conn.setAutoCommit(false);
	}

	/**
	 * selectを実行するﾒｿｯﾄﾞ
	 * getInstanceメソッドを呼んだ後に呼ぶこと
	 *
	 * @param sql 実行対象SQL
	 * @return 結果セット
	 * @throws SQLException SQL実行に失敗したとき
	 */
	public ResultSet executeSelect(String sql) throws SQLException{
		//ステートメントを設立
		stmt = conn.createStatement();

		//select文を発行
		rs = stmt.executeQuery(sql);

		//実行結果を返します
		return rs;
	}

	/**
	 * insert,update,deleteを実行するメソッド
	 * getInstanceメソッドを呼んだ後に呼ぶこと
	 *
	 * @param sql 実行対象SQL
	 * @return 結果件数
	 * @throws SQLException SQL実行に失敗したとき
	 */
	public int executeUpdate(String sql) throws SQLException {
		//戻り値の設定
		int successCount = 0;

		//ステートメントを設立
		stmt = conn.createStatement();

		//SQL文の実行
		successCount = stmt.executeUpdate(sql);

		return successCount;
	}

	/**
	 * insert,update,deleteを実行するメソッド
	 * getInstanceメソッドを呼んだ後に呼ぶこと
	 *
	 * @param PreparedStatement ステートメント
	 * @return 結果件数
	 * @throws SQLException SQL実行に失敗したとき
	 */
	public int executeUpdate( PreparedStatement pstmt ) throws SQLException {

		//戻り値の設定
		int successCount = 0;

		this.pstmt = pstmt;

		//SQL文の実行
		successCount = pstmt.executeUpdate();

		return successCount;
	}

	/**
	 * PreparedStatementを生成するメソッド
	 * getInstanceメソッドを呼んだ後に呼ぶこと
	 *
	 * @return PreparedStatement
	 * @throws SQLException SQL実行に失敗したとき
	 */
	public PreparedStatement createPrepareStatement( String sql ) throws SQLException {

		//ステートメントを設立
		pstmt = conn.prepareStatement( sql );

		return pstmt;
	}

	/**
	 * コミット
	 */
	public void commit() {
		try {
			if (conn != null) {
				//コネクションのインスタンスがある場合は、コミット
				conn.commit();
				System.out.println("コネクションをコミットしました。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ロールバック
	 */
	public void rollback() {
		try {
			if (conn != null) {
				//コネクションのインスタンスがある場合は、ロールバック
				conn.rollback();
				System.out.println("コネクションをロールバックしました。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * closeするﾒｿｯﾄ
	 */
	public void closeAll(){
		try {
			if(rs != null){
				rs.close();
				rs = null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			if(stmt != null){
				stmt.close();
				stmt = null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			if(pstmt != null){
				pstmt.close();
				pstmt = null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			if(conn != null){
				conn.close();
				conn = null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
