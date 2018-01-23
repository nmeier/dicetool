/* The MIT License
 * 
 * Copyright (c) 2004,2005 David Rice
 * 
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation files 
 * (the "Software"), to deal in the Software without restriction, 
 * including without limitation the rights to use, copy, modify, merge, 
 * publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, 
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be 
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS 
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN 
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN 
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE 
 * SOFTWARE.
 */
package net.rptools.dicetool.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import net.rptools.dicetool.resultset.Row;
import net.rptools.dicetool.resultset.Row;


/**
 *
 * @author  drice
 */
public class ResultPanel extends javax.swing.JPanel implements RollListener, MouseListener {
    private static final long serialVersionUID = -6416009322085819601L;

    private final MainFrame tool;
	
    private RowListModel tableModel;
    
    /** Creates new form ResultPanel */
    public ResultPanel(MainFrame tool) {
    	this.tool = tool;
        initComponents();
        
        tool.registerRollListener(this);
    }
    
    public void clearList() {
        tableModel.clear();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        scrollPane = new javax.swing.JScrollPane();
        tableModel = new RowListModel();
        resultTable = new ResultTable(tool);
        
        //resultTable.setRowSelectionAllowed(false);
        //resultTable.setCellSelectionEnabled(false);
        //resultTable.setColumnSelectionAllowed(false);
        
        //resultTable.addRowSelectionInterval(1, 15);
        
		resultTable.addMouseListener(this);
		
        setLayout(new java.awt.BorderLayout());

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        resultTable.setModel(tableModel);
        
/*		
        resultTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        resultTable.getColumnModel().getColumn(1).setPreferredWidth(5);
        resultTable.getColumnModel().getColumn(2).setPreferredWidth(5);
*/
        
        scrollPane.setViewportView(resultTable);

        add(scrollPane, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents

    public void add(String... expressions) {
    	for (String x : expressions) {
    		tableModel.addRow(new Row(x));
    	}
    }
    
    public void add(List<String> expressions) {
    	for (String x : expressions) {
    		tableModel.addRow(new Row(x));
    	}
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList resultTable;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
    
	/**
	 * @return
	 */
	public RowListModel getTableModel() {
		return tableModel;
	}

	/**
	 * @return Returns the resultTable.
	 */
	public javax.swing.JList getResultTable() {
		return resultTable;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
	}

	public void rolled(List<String> expressions) {
		add(expressions);
	}
}
