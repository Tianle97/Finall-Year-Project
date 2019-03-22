package ie.gmit.sw.shoppingInfoService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.gmit.sw.models.OrderInfo;
import ie.gmit.sw.repositories.OrderInforRepositries;

@Service("ShoppingInfoServiceImp")
public class OrderInfoServiceImp implements OrderInfoService {

	@Autowired
	private OrderInforRepositries orderInforRepositries;

	@Override
	public ArrayList<OrderInfo> showAll(String username) {
		// create a empty array list
		ArrayList<OrderInfo> orderInfos = null;

		// get all information from mongodb according to userName
		orderInfos = orderInforRepositries.findByUsername(username);

		return orderInfos;
	}

	// add user Shopping details save in mongodb
	@Override
	public String addOrderInfo(OrderInfo orderInfo) {
		orderInforRepositries.save(orderInfo);

		return "create order seccessful";
	}

}
