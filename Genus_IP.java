package workshop;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import jv.object.PsConfig;
import jv.object.PsDialog;
import jv.object.PsUpdateIf;
import jvx.project.PjWorkshop_IP;

public class Genus_IP extends PjWorkshop_IP implements ActionListener {

	protected Button m_bComputeGenus;
	protected Label m_lGenus;
	
	Genus m_genus;
	
	public Genus_IP() {
		super();
		if(getClass() == Genus_IP.class)
			init();
	}
	
	public void init() {
		super.init();
		setTitle("Compute Genus");
	}
	
	public String getNotice() {
		return "By clicking the button below, you will get the genus of the current model.";
	}
	
	public void setParent(PsUpdateIf parent) {
		super.setParent(parent);
		m_genus = (Genus)parent;
	
		// addSubTitle("Example of a subtitle");
		addSubTitle(" ");
		
		m_bComputeGenus = new Button("Compute Genus");
		m_bComputeGenus.addActionListener(this);
		m_lGenus = new Label("NULL");
		Panel panel1 = new Panel(new FlowLayout(FlowLayout.CENTER));
		panel1.add(m_bComputeGenus);
		panel1.add(m_lGenus);
		add(panel1);
		
		validate();
	}
	
	/**
	 * Handle action events fired by buttons etc.
	 */
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == m_bComputeGenus) {
			int genus = m_genus.computeGenus();
			m_lGenus.setText(Integer.toString(genus));
			m_genus.m_geom.update(m_genus.m_geom);
			return;
		}		
	}
	/**
	 * Get information which bottom buttons a dialog should create
	 * when showing this info panel.
	 */
	protected int getDialogButtons()		{
		return PsDialog.BUTTON_OK;
	}
}
