package springtest3.system;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 08:56
 */
@Component
public class Container<T> {
    private List<T> objs = new ArrayList<T>();

    //TODO 要使用spring完成 DI
    @Resource(name = "bmiMeasure")
    private Measure measure;
    @Resource(name = "bmiFilter")
    private ContainerFilter filter;

    private T max;
    private T min;
    private double avg;
    private double sum;

    /**
     * 添加对象的方法
     *
     * @param t
     */
    public void add(T t) {
        //TODO:
        // 判断t 是否合格 调用筛选的实现
        if (filter != null) {
            if (filter.doFilter(t) == false) {
                return;
            }
        }
        //添加到 objs
        objs.add(t);
        //判断大小 记录 max min 计算 avg  => 调用measure 的实现
        if (objs.size() == 1) {
            max = t;
            min = t;
        } else {
            //测量出值 判断大小
            double val = this.measure.doMeasure(t);
            double maxval = this.measure.doMeasure(max);
            double minval = this.measure.doMeasure(min);
            if (val > maxval) {
                max = t;
            }
            if (val < minval) {
                min = t;
            }
        }
        sum += measure.doMeasure(t);
        avg = sum / objs.size();
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

    public double getAvg() {
        return avg;
    }

    /**
     * 有效的测量 对象有多少个
     *
     * @return
     */
    public int size() {
        return objs.size();
    }

    /**
     * 系统复位
     */
    public void cleanAll() {
        objs = new ArrayList<>();
        measure = null;
        filter = null;
        max = null;
        min = null;
        avg = 0;
    }
}
