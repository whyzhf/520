package why.thread;

/**
 * @Auther: why
 * @Data:2018/10/18
 * @Deacription:
 */
public class demo {
    public static void main(String[] args) {
        standard(100,500,5);
    }

    public static void standard(double cormax, double cormin, double cornumber) {
        double realmaxmoney, realminmoney, corstep, tmpstep, tmpnumber, temp, extranumber;
        realmaxmoney = Double.valueOf(cormax);
        realminmoney = Double.valueOf(cormin);
        if (cormax <= cormin)
            return;
        corstep = (cormax - cormin) / cornumber;
        if (Math.pow(10, (int) (Math.log(corstep) / Math.log(10))) == corstep) {
            temp = Math.pow(10, (int) (Math.log(corstep) / Math.log(10)));
        } else {
            temp = Math.pow(10, ((int) (Math.log(corstep) / Math.log(10)) + 1));
        }
        tmpstep = corstep / temp;
        //选取规范步长
        if (tmpstep >= 0 && tmpstep <= 0.1) {
            tmpstep = 0.1;
        } else if (tmpstep >= 0.100001 && tmpstep <= 0.2) {
            tmpstep = 0.2;
        } else if (tmpstep >= 0.200001 && tmpstep <= 0.25) {
            tmpstep = 0.25;
        } else if (tmpstep >= 0.250001 && tmpstep <= 0.5) {
            tmpstep = 0.5;
        } else {
            tmpstep = 1;
        }
        tmpstep = tmpstep * temp;
        if ((int) (cormin / tmpstep) != (cormin / tmpstep)) {
            if (cormin < 0) {
                cormin = (-1) * Math.ceil(Math.abs(cormin / tmpstep)) * tmpstep;
            } else {
                cormin = (int) (Math.abs(cormin / tmpstep)) * tmpstep;
            }

        }
        if ((int) (cormax / tmpstep) != (cormax / tmpstep)) {
            cormax = (int) (cormax / tmpstep + 1) * tmpstep;
        }
        tmpnumber = (cormax - cormin) / tmpstep;
        if (tmpnumber < cornumber) {
            extranumber = cornumber - tmpnumber;
            tmpnumber = cornumber;
            if (extranumber % 2 == 0) {
                cormax = cormax + tmpstep * (int) (extranumber / 2);
            } else {
                cormax = cormax + tmpstep * (int) (extranumber / 2 + 1);
            }
            cormin = cormin - tmpstep * (int) (extranumber / 2);
        }
        cornumber = tmpnumber;

        double nummoney = 0;
        String text = "";
        double keduwidth = (cormax - cormin) / cornumber;

        for (int i = 1; nummoney < realmaxmoney; i++) {
            nummoney = keduwidth * i + cormin;
            text = text + String.valueOf(nummoney) + "---";
            System.out.println("wwwwwwwww:"+ text);
        }


    }
}
