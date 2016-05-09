package workshop;

import java.awt.Color;
import java.util.Random;
import java.util.Arrays;

import jv.geom.PgElementSet;
import jv.project.PgGeometry;
import jv.vecmath.PdVector;
import jv.vecmath.PiVector;
import jvx.project.PjWorkshop;

public class Valences extends PjWorkshop {

	PgElementSet m_geom;
	PgElementSet m_geomSave;

	public Valences() {
		super("Valences");
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

	public int[] getValences() {
		int nov = m_geom.getNumVertices();
		PiVector valencesVector = new PiVector(nov);
		int[] valences = new int[nov];
		valencesVector = m_geom.getVertexValence(m_geom);
		for (int i = 0; i < nov ; i++ ) {
			valences[i] = valencesVector.getEntry(i);
		}
		return valences;
	}

	public int getValencesVectorSize() {
		int nov = m_geom.getNumVertices();
		PiVector valencesVector = new PiVector(nov);
		valencesVector = m_geom.getVertexValence(m_geom);
		return valencesVector.getSize();
	}

	public int getMaxValences() {
		int nov = m_geom.getNumVertices();
		PiVector valencesVector = new PiVector(nov);
		int[] valences = new int[nov];
		valencesVector = m_geom.getVertexValence(m_geom);
		for (int i = 0; i < nov ; i++ ) {
			valences[i] = valencesVector.getEntry(i);
		}
		int valencesMax = valences[0];
		for (int i = 1; i < valences.length; i++) {
			if (valences[i] > valencesMax) {
				valencesMax = valences[i];
			}
		}
		return valencesMax;
	}

	public int getMinValences() {
		int nov = m_geom.getNumVertices();
		PiVector valencesVector = new PiVector(nov);
		int[] valences = new int[nov];
		valencesVector = m_geom.getVertexValence(m_geom);
		for (int i = 0; i < nov ; i++ ) {
			valences[i] = valencesVector.getEntry(i);
		}
		int valencesMin = valences[0];
		for (int i = 1; i < valences.length; i++) {
			if (valences[i] < valencesMin) {
				valencesMin = valences[i];
			}
		}
		return valencesMin;
	}

	public double getMeanValences() {
		int nov = m_geom.getNumVertices();
		PiVector valencesVector = new PiVector(nov);
		int[] valences = new int[nov];
		valencesVector = m_geom.getVertexValence(m_geom);
		for (int i = 0; i < nov ; i++ ) {
			valences[i] = valencesVector.getEntry(i);
		}
		int valencesSum = 0;
		for (int j = 1; j < valences.length; j++) {
			valencesSum += valences[j];
		}
		double valencesMean = valencesSum / valences.length;
		return valencesMean;
	}

	public double getStandardDeviation() {
		int nov = m_geom.getNumVertices();
		PiVector valencesVector = new PiVector(nov);
		int[] valences = new int[nov];
		valencesVector = m_geom.getVertexValence(m_geom);
		for (int i = 0; i < nov ; i++ ) {
			valences[i] = valencesVector.getEntry(i);
		}
		int valencesSum = 0;
		for (int j = 1; j < valences.length; j++) {
			valencesSum += valences[j];
		}
		double valencesMean = valencesSum / valences.length;
		int sumValencesSquare = 0;
		for (int k = 1; k < valences.length; k++) {
			sumValencesSquare += Math.pow(valences[k], 2);
		}
		double standardDeviation = Math.sqrt(sumValencesSquare / valences.length - Math.pow(valencesMean, 2));
		return standardDeviation;
	}
}
