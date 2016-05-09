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

public class Valences_IP extends PjWorkshop_IP implements ActionListener {

	protected Button m_bgetValences;
	protected Button m_bgetvalencesVectorSize;
	protected Button m_bgetMaxValences;
	protected Button m_bgetMinValences;
	protected Button m_bgetMeanValences;
	protected Button m_bstandardDeviation;
	protected Label m_lValences;
	protected Label m_lvalencesVectorSize;
	protected Label m_lMaxValences;
	protected Label m_lMinValences;
	protected Label m_lMeanValences;
	protected Label m_lstandardDeviation;

	Valences m_valences;

	public Valences_IP() {
		super();
		if (getClass() == Valences_IP.class)
			init();
	}

	public void init() {
		super.init();
		setTitle("Info of Valences");
	}

	public String getNotice() {
		return "By clicking the buttons below, you will get the information of valences of all vertices in the current model.";
	}

	public void setParent(PsUpdateIf parent) {
		super.setParent(parent);
		m_valences = (Valences)parent;

		// addSubTitle("Example of a subtitle");
		addSubTitle(" ");

		m_bgetValences = new Button("Get Valences");
		m_bgetValences.addActionListener(this);
		m_bgetvalencesVectorSize = new Button("Get Valences Vector Size");
		m_bgetvalencesVectorSize.addActionListener(this);
		m_bgetMaxValences = new Button("Get Maximum Valences");
		m_bgetMaxValences.addActionListener(this);
		m_bgetMinValences = new Button("Get Minimum Valences");
		m_bgetMinValences.addActionListener(this);
		m_bgetMeanValences = new Button("Get Mean of Valences");
		m_bgetMeanValences.addActionListener(this);
		m_bstandardDeviation = new Button("Calculate the Standard Deviation");
		m_bstandardDeviation.addActionListener(this);
		m_lValences = new Label("valences");
		m_lvalencesVectorSize = new Label("size");
		m_lMaxValences = new Label("maxValences");
		m_lMinValences = new Label("minValences");
		m_lMeanValences = new Label("meanValences");
		m_lstandardDeviation = new Label("standardDeviation");
		Panel panel1 = new Panel(new FlowLayout(FlowLayout.CENTER));
		//panel1.add(m_bgetValences);
		//panel1.add(m_lValences);
		//panel1.add(m_bgetvalencesVectorSize);
		//panel1.add(m_lvalencesVectorSize);
		panel1.add(m_bgetMaxValences);
		panel1.add(m_lMaxValences);
		panel1.add(m_bgetMinValences);
		panel1.add(m_lMinValences);
		panel1.add(m_bgetMeanValences);
		panel1.add(m_lMeanValences);
		panel1.add(m_bstandardDeviation);
		panel1.add(m_lstandardDeviation);
		add(panel1);

		validate();
	}

	/**
	 * Handle action events fired by buttons etc.
	 */
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == m_bgetvalencesVectorSize) {
			int valencesVectorSize = m_valences.getValencesVectorSize();
			m_lvalencesVectorSize.setText(Integer.toString(valencesVectorSize));
			m_valences.m_geom.update(m_valences.m_geom);
			return;
		}
		if (source == m_bgetMaxValences) {
			int maxValences = m_valences.getMaxValences();
			m_lMaxValences.setText(Integer.toString(maxValences));
			m_valences.m_geom.update(m_valences.m_geom);
			return;
		}
		if (source == m_bgetMinValences) {
			int minValences = m_valences.getMinValences();
			m_lMinValences.setText(Integer.toString(minValences));
			m_valences.m_geom.update(m_valences.m_geom);
			return;
		}
		if (source == m_bgetMeanValences) {
			double meanValences = m_valences.getMeanValences();
			m_lMeanValences.setText(Double.toString(meanValences));
			m_valences.m_geom.update(m_valences.m_geom);
			return;
		}
		if (source == m_bstandardDeviation) {
			double standardDeviation = m_valences.getStandardDeviation();
			m_lstandardDeviation.setText(Double.toString(standardDeviation));
			m_valences.m_geom.update(m_valences.m_geom);
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
