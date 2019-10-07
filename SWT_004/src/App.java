import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class App {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text txtResultado;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			App window = new App();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(385, 170);
		shell.setText("SWT Application");
		
		Label lblUnidades = new Label(shell, SWT.NONE);
		lblUnidades.setBounds(10, 10, 55, 15);
		lblUnidades.setText("Unidades");
		
		Label lblPrecio = new Label(shell, SWT.NONE);
		lblPrecio.setBounds(10, 41, 55, 15);
		lblPrecio.setText("Precio");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(71, 7, 288, 25);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(71, 38, 288, 25);
		
		txtResultado = new Text(shell, SWT.BORDER);
		txtResultado.setToolTipText("");
		txtResultado.setEditable(false);
		txtResultado.setBounds(71, 69, 288, 25);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(10, 67, 55, 25);
		btnNewButton.setText("Calcular");
		
		Label lblMensaje = new Label(shell, SWT.NONE);
		lblMensaje.setAlignment(SWT.CENTER);
		lblMensaje.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblMensaje.setForeground(SWTResourceManager.getColor(128, 0, 0));
		lblMensaje.setBounds(10, 100, 349, 21);
		
		//Listeners
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					float resultado = Integer.parseInt(text.getText())*Float.valueOf(text_1.getText());
					
					if(resultado == 0.0)
						lblMensaje.setText("No puede tener el valor 0");
					else
					{
						lblMensaje.setText("");
						txtResultado.setText(Float.toString(resultado));
					}
				}
				catch(Exception e1)
				{
					lblMensaje.setText("Error");
					txtResultado.setText("");
				}
			}
		});
	}
}
