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

public class Volume_IP extends PjWorkshop_IP implements ActionListener {

	protected Button m_bComputeVolume;
	protected Label m_lVolume;
	
	Volume m_volume;
	
	public Volume_IP() {
		super();
		if(getClass() == Volume_IP.class)
			init();
	}
	
	public void init() {
		super.init();
		setTitle("Compute Volume");
	}
	
	public String getNotice() {
		return "By clicking the button below, you will get the volume of the current model.";
	}
	
	public void setParent(PsUpdateIf parent) {
		super.setParent(parent);
		m_volume = (Volume)parent;
	
		// addSubTitle("Example of a subtitle");
		addSubTitle(" ");
		
		m_bComputeVolume = new Button("Compute Volume");
		m_bComputeVolume.addActionListener(this);
		m_lVolume = new Label("volume");
		Panel panel1 = new Panel(new FlowLayout(FlowLayout.CENTER));
		panel1.add(m_bComputeVolume);
		panel1.add(m_lVolume);
		add(panel1);
		
		validate();
	}
	
	/**
	 * Handle action events fired by buttons etc.
	 */
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == m_bComputeVolume) {
			double volume = m_volume.computeVolume();
			m_lVolume.setText(Double.toString(volume));
			m_volume.m_geom.update(m_volume.m_geom);
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
