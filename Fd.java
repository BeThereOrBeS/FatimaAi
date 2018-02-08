import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

//this is the main program on Fatima-Ai.
//and the templete of real AI chatting application in the future.
//any useful API like math-common or stuff like that,i would add it.

public class Fd extends JFrame {
//	extends JFrameのほうが良い？

	public int i, j, k, l, m, n, o, p, q, r, s, t, u, v;
	public int intCount;
	JTextArea tarScreen = new JTextArea();
	Connection myCon = null;
	Statement mySt = null;
	ResultSet myRs;

	ImageIcon icon = new ImageIcon("f.gif");
	Image image = icon.getImage();

	ImageIcon icon2 = new ImageIcon("ft.gif");
	Image image2 = icon2.getImage();
	ImageIcon icon3 = new ImageIcon("ft1.gif");
	Image image3 = icon3.getImage();
	ImageIcon icon4 = new ImageIcon("ft2.gif");
	Image image4 = icon4.getImage();
	ImageIcon icon5 = new ImageIcon("ft4.gif");
	Image image5 = icon5.getImage();
	ImageIcon icon6 = new ImageIcon("ft5.gif");
	Image image6 = icon6.getImage();

	public JLabel fatima2 = new JLabel();
	public JLabel fatima3 = new JLabel();
	public JLabel fatima = new JLabel();
	public JLabel fatima4 = new JLabel();
	public JLabel fatima5 = new JLabel();

	//fatima.setIcon(null);
	//fatima.setIcon(icon2);
	//pnlMdl.add(fatima);

	//一段目
	JPanel panelAbove;
	JRadioButton teachAi;
	JRadioButton hearAi;
	ButtonGroup tandh = new ButtonGroup();
	JButton indx;

	//二段目
	public JLabel angry;

	//三段目
	public JPanel angPnl = new JPanel();
	public JRadioButton[] radios = new JRadioButton[10];
	public ButtonGroup group = new ButtonGroup();
	public JTextField ending1 = new JTextField("AIのファティマがブラウザの前で腐ってるあなたを適当に慰めるアプリです。",40);

	//四段目
	public JLabel grief;

	//五段目
	public JPanel grfPnl = new JPanel();
	public JRadioButton[] radiosx = new JRadioButton[10];
	public ButtonGroup groupx = new ButtonGroup();
	public JTextField ending2 = new JTextField("また、彼女に感情や台詞を覚えさせる事もできますが、あなた次第です。",40);

	//六段目
	public JTextField syng = new JTextField("Spit it out(AIに覚えさせたい台詞)!",25);

	//以上５つの要素を載せるミドルパネル
	public JPanel pnlMdl = new JPanel();

	//最下段で全てのコマンドを実行
	JButton btnAction = new JButton("Commit On!");
	
	//アプレットにする場合はpublic void init(){}でJFrameをJAppletにextendだが・・・
	public Fd(String title) {

		super(title);

		// フレームを作成してレイアウトをセット
		pnlMdl.setLayout(new GridLayout(5,1));

		//一段目のパネルレイアウト
		panelAbove = new JPanel();
		panelAbove.setLayout(new GridLayout(1,3));
		teachAi = new JRadioButton("Teach Ai",true);
		hearAi = new JRadioButton("U hear Ai");
		indx = new JButton("To Home");

		// パネルにボタンをセット
		tandh.add(teachAi);
		tandh.add(hearAi);
		panelAbove.add(teachAi);
		panelAbove.add(hearAi);
		panelAbove.add(indx);

		//一段目をJFrameに乗せる
		this.add(panelAbove);

		//ラベルにラジオボタン選択でテキスト書き換え
		angry = new JLabel();
		grief = new JLabel();

		//AIに教える感情
		teachAi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

			//fatima.setIcon(null);
			pnlMdl.removeAll();
			angPnl.removeAll();
			grfPnl.removeAll();

			angry.setIcon(icon);
			angry.setText("Fatima's degree of kawaii(ファティマの魅力度)");

			for(i=0;i<10;i++) {
				if(i == 5){radios[i] = new JRadioButton("["+i+"]",true);}
				else{radios[i] = new JRadioButton("["+i+"]");}
				group.add(radios[i]);
				angPnl.add(radios[i]);
			}

			grief.setText("Fatima's degree of grief(ファティマの慈しみ度)");

			for(j=0;j<10;j++) {
				if(j == 5){radiosx[j] = new JRadioButton("["+j+"]",true);}
				else{radiosx[j] = new JRadioButton("["+j+"]");}
				groupx.add(radiosx[j]);
				grfPnl.add(radiosx[j]);
			}
			syng.setText("Spit it out(ファティマが覚えるよ)!");

			pnlMdl.add(angry);
			pnlMdl.add(angPnl);
			pnlMdl.add(grief);
			pnlMdl.add(grfPnl);
			pnlMdl.add(syng);
			pnlMdl.validate();
			pnlMdl.repaint();
			//pnlMdl.setSize(pnlMdl.getPreferredSize());

			}
		});

		hearAi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

			//fatima.setIcon(null);
			pnlMdl.removeAll();
			angPnl.removeAll();
			grfPnl.removeAll();

			syng.setText("Spit it out(そうだ吐きだせ誰が憎いんだい)");
			angry.setIcon(null);
			angry.setText("Your degree of anger(貴方の怒り度)");

			for(k=0; k<9; k++) {
				if(k == 5){radios[k] = new JRadioButton("["+k+"]",true);}
				else{radios[k] = new JRadioButton("["+k+"]");}
				group.add(radios[k]);
				angPnl.add(radios[k]);
			}

			grief.setText("Your degree of grief(貴方の腐り度)");

			for(l=0; l<9; l++) {
				if(l == 5){radiosx[l] = new JRadioButton("["+l+"]",true);}
				else{radiosx[l] = new JRadioButton("["+l+"]");}
				groupx.add(radiosx[l]);
				grfPnl.add(radiosx[l]);
			}

			pnlMdl.add(syng);
			pnlMdl.add(angry);
			pnlMdl.add(angPnl);
			pnlMdl.add(grief);
			pnlMdl.add(grfPnl);
			pnlMdl.validate();
			pnlMdl.repaint();

			}
		});

		indx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

			//fatima.setIcon(null);
			pnlMdl.removeAll();
			angPnl.removeAll();
			grfPnl.removeAll();

			angry.setIcon(null);
			angry.setText("This application hits the spot when you piss!");

			//grief.setIcon(icon);
			grief.setText("Cause Fatima-AI is always on your side,Punks!");
			syng.setText("All rights reserverd by Muon企画.corp[ご意見頂いても架空の会社なので届きません]");

			angPnl.add(ending1);
			grfPnl.add(ending2);

			pnlMdl.add(angry);
			pnlMdl.add(angPnl);
			pnlMdl.add(grief);
			pnlMdl.add(grfPnl);
			pnlMdl.add(syng);
			pnlMdl.validate();
			pnlMdl.repaint();

			}
		});


		btnAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try{
	
				// 先程インストールしたMySQLのドライバを指定
				Class.forName("com.mysql.jdbc.Driver");
				// MySQLデータベースに接続 (DB名,ID,パスワードを指定)
				myCon = DriverManager.getConnection("jdbc:mysql://localhost/php10?"+"user=root&password=12345");
	
				if(teachAi.isSelected()){
					for(m=0;m<10;m++) {
						if(radios[m].isSelected()){
							o = m;
							break;
						}
					}
					for(n=0;n<10;n++) {
						if(radiosx[n].isSelected()){
							p = n;
							break;
						}
					}
	
					String strSQL = "INSERT INTO aibrain02 (swinging, feeling, saying) VALUES('" + o + "','" + p + "','" +  syng.getText() + "')";
					mySt = myCon.createStatement();
					intCount = mySt.executeUpdate(strSQL);
					showMyMessage("台詞を"+intCount + "つ、ファティマは覚えました。");
				}
	
				if(hearAi.isSelected()){
					for(q=0;q<10;q++) {
						if(radios[q].isSelected()){
							s = q;
							break;
						}
					}
					for(r=0;r<10;r++) {
						if(radiosx[r].isSelected()){
							t = r;
							break;
						}
					}
					TalkAi(s,t);
				}
				//
				//showMyMessage("ｔｒｙ文内で" + o + "と" + p + "さらに平方根は" + (int)Math.sqrt(o*p) + "です");
				}catch (Exception ex) {
					showMyMessage("例外" + ex + "発生！");
				}finally{
					try{
						if(mySt != null) {
							mySt.close();
						}
						if(myCon != null){
							myCon.close();
					      	}
					}catch(SQLException sx){
						showMyMessage("エラー発生" + sx);
					}
				}

			}
		});

		fatima.setIcon(icon3);
		fatima2.setIcon(icon4);
		fatima3.setIcon(icon2);
		fatima4.setIcon(icon5);
		fatima5.setIcon(icon6);
		pnlMdl.add(fatima);
		pnlMdl.add(fatima2);
		pnlMdl.add(fatima3);
		pnlMdl.add(fatima4);
		pnlMdl.add(fatima5);

		// フレームにパネルをセット（BorderLayoutの北側と真ん中）
		this.add(panelAbove, BorderLayout.NORTH);
		this.add(pnlMdl, BorderLayout.CENTER);
		this.add(btnAction, BorderLayout.SOUTH);

	}


	void showMyMessage(String strMessage) {
		JOptionPane.showMessageDialog(this, strMessage);
	}

	void TalkAi(int a,int b) {

		int AiF;

		AiF = (int)Math.sqrt(a*b);

		try {
			mySt = myCon.createStatement() ;
			//mySql側のカラムの名前を決める必要がある。aibrain,swinging,feeling,saying
			myRs = mySt.executeQuery("SELECT * FROM aibrain WHERE feeling = "+AiF);
			StringBuffer strMes = new StringBuffer();
			String line;

			while(myRs.next()){
				line = myRs.getString("saying") ;
			 	strMes.append(line + "\n");

			}
			JOptionPane.showMessageDialog(this, strMes.toString());
		}catch(Exception ex) {
	//		showMyMessage("doUpdateAiでエラー発生：" + ex);
			//intCount = 0;
			}
	}

	public static void main(String args[]) {
		Fd myAppli = new Fd("Simple Ai");
		//myAppli.setLayout(new GridLayout(3,1));
		myAppli.setSize(500,500);
		myAppli.setVisible(true);
	}

}
