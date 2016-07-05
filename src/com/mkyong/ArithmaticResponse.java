package com.mkyong;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArithmaticResponse {
int arithmaticRes;

public int getArithmaticRes() {
	return arithmaticRes;
}

public void setArithmaticRes(int arithmaticRes) {
	this.arithmaticRes = arithmaticRes;
}
}
