package rocket.app.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import eNums.eAction;
import exceptions.RateException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketBase.RateDAL;
import rocketCode.Action;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class MortgageController {

	@FXML private TextField txtCreditScore;
	@FXML private TextField txtMortgageAmt;
	
			
			@FXML private TextField txtHouseCost;
			@FXML private TextField txtDownPayment;
			@FXML private TextField txtIncome;
			@FXML private TextField txtMonthlyCost;
			@FXML private ComboBox cmbTerm;	
			
			@FXML private Label lblMortgagePayment;
			@FXML private Button button;
			@FXML private Label errorText;
			
			@FXML private TextField creditScore;
	
	
	
	
	
	
	private TextField txtNew;
	
	private MainApp mainApp;
	

	public void setMainApp(MainApp mainApp) {
	cmbTerm.getItems().clear();
	cmbTerm.getItems().addAll("15","30");
		
		this.mainApp = mainApp;
		
		
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		LoanRequest lq=new LoanRequest();
		
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		lq.setExpenses(Double.parseDouble(txtMonthlyCost.getText()));
		lq.setiDownPayment(Integer.parseInt(txtDownPayment.getText()));
		lq.setIncome(Double.parseDouble(txtIncome.getText()));
		lq.setiTerm(Integer.parseInt((String)cmbTerm.getValue()));
		lq.setiCreditScore(Integer.parseInt(creditScore.getText()));

		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		

		NumberFormat formatter = new DecimalFormat("#0.00");     
		lblMortgagePayment.setText("$ "+formatter.format(Math.abs(lRequest.getdPayment())));
		errorText.setText(" ");
	}
	
	public void HandleError(RateException re)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		lblMortgagePayment.setText(" ");
		errorText.setText(re.getErrMessage());
		
	}
	
	
}