package br.usjt.desmob.geodata;

import android.widget.ImageView;
import android.widget.TextView;

/*
    Haohhmaru (c) 03/31/2018
    Alessandro Lima da silva
    RA: 201522705
    Turma: CCP3AN-MCA2
 */

public class ViewHolder {
    ImageView flag;
    TextView name, detail;

    public ViewHolder(ImageView flag, TextView name, TextView detail) {
        this.flag = flag;
        this.name = name;
        this.detail = detail;
    }

    public ImageView getFlag() {
        return flag;
    }

    public void setFlag(ImageView flag) {
        this.flag = flag;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getDetail() {
        return detail;
    }

    public void setDetail(TextView detail) {
        this.detail = detail;
    }
}
