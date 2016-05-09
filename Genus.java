package workshop;

import java.awt.Color;
import java.util.Random;

import jv.geom.PgElementSet;
import jv.project.PgGeometry;
import jv.vecmath.PdVector;
import jv.vecmath.PiVector;
import jvx.project.PjWorkshop;

public class Genus extends PjWorkshop {

	PgElementSet m_geom;
	PgElementSet m_geomSave;

	public Genus() {
		super("Genus");
		init();
	}

	@Override
	public void setGeometry(PgGeometry geom) {
		super.setGeometry(geom);
		m_geom 		= (PgElementSet)super.m_geom;
		m_geomSave 	= (PgElementSet)super.m_geomSave;
	}

	public void init() {
		super.init();
	}

	public int computeGenus() {
		int nov = m_geom.getNumVertices();
		int noe = m_geom.getNumEdges();
		int nof = m_geom.getNumElements();
		int genus = 1 - (nov - noe + nof) / 2;
		return genus;
	}
}
