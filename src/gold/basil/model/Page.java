package gold.basil.model;

import java.io.Serializable;
import java.util.List;

/** 
* @author  Basil 
* @version 1.0
* @创建时间 2020年6月24日 下午7:02:13
* @描述 分页 
*/
public class Page implements Serializable {
	int start;      // 开始数据的索引
    int count;      // 每一页的数量
    int total;      // 总共的数据量

    /**
     * 提供一个构造方法
     * @param start
     * @param count
     */ 
    public Page(int start, int count) {
        this.start = start;
        this.count = count;
    }

    /**
     * 判断是否有上一页
     * @return
     */
    public boolean isHasPreviouse(){
        if(start==0)
            return false;
        return true;

    }
    
    /**
     * 判断是否有下一页
     * @return
     */
    public boolean isHasNext(){
        if(start==getLast())
            return false;
        return true;
    }

    /**
     * 计算得到总页数
     * @return
     */
    public int getTotalPage(){
        int totalPage;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (0 == total % count)
            totalPage = total /count;
            // 假设总数是51，不能够被5整除的，那么就有11页
        else
            totalPage = total / count + 1;

        if(0==totalPage)
            totalPage = 1;
        return totalPage;
    }

    /**
     * 计算得到尾页
     * @return
     */
    public int getLast(){
        int last;
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if (0 == total % count)
            last = total - count;
            // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        else
            last = total - total % count;

        last = last<0?0:last;
        return last;
    }

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
	
}
