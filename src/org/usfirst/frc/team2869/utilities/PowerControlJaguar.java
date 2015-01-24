package org.usfirst.frc.team2869.utilities;

import edu.wpi.first.wpilibj.Jaguar;

public class PowerControlJaguar extends Jaguar {

	double reduction;
	double reductionTable [];
	
	public PowerControlJaguar(int channel) {
		this(channel, 1);
		reductionTable = null;
	}

	public PowerControlJaguar(int channel, double factor) {
		super(channel);
		reductionTable = null;
		reduction = factor;
	}
	
	public PowerControlJaguar(int channel, double [] factors) {
		super(channel);
		reductionTable = factors;
	}
	
	public void set(double speed) {
		double value;
		int index;
		if (reductionTable == null) {
			value = reduction * speed;
		} else {
			index = (int)(Math.abs(speed) * 9.99);
			value = reductionTable[index] * speed;
		}
		super.set(value);
	}
	
	public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

    public double[] getReductionTable() {
        return reductionTable;
    }

    public void setReductionTable(double[] reductionTable) {
        this.reductionTable = reductionTable;
    }

}
