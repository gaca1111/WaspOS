package ProcessesManagment;
import java.lang.Object;
import java.util.LinkedList;
import java.util.List;

public class ProcessesManagment extends Proces {

	//===ZMIENNE=========================================================================================
	
	public List<Proces> processesList;
	
	private ID_Overseer overseer;
	
	//===METODY==========================================================================================
	
	//---Konstruktor-------------------------------------------------------------------------------------
	
	public ProcessesManagment(){
		
		processesList = new LinkedList<Proces>();
		overseer = new ID_Overseer();
	}
	
	//---Dodaj nowy proces--------------------------------------------------------------------------------

	public void NewProcess(){
		
		Proces process = new Proces();
		process.CreateProcess(overseer.PickID());
	
		processesList.add(process);
	}

	public void NewProcess(String ProgramPath_Original){
		
		Proces process = new Proces();
		process.CreateProcess(overseer.PickID(),ProgramPath_Original);
	
		processesList.add(process);
	}
	
	public void NewProcess(String ProgramPath_Original, String Name) {
		
		Proces process = new Proces();
		process.CreateProcess(overseer.PickID(),ProgramPath_Original, Name);;
	
		processesList.add(process);
	}
	
	//---odszukiwanie procesu o podanym ID---------------------------------------------------------------
	
	public int FindProcessWithID(int ID) {
		
		Proces proces_kopia;
		
		for(int i = 0; i < processesList.size(); i++) {
			
			proces_kopia = processesList.get(i);
			
			if(proces_kopia.GetID() == ID) {
				
				return i;
			}	
		}
		
		return -1;
	}
	
	//---odczytaj dane procesu----------------------------------------------------------------------------
	
	public void ReadProcessInformations(int ID) {
		
		int index = FindProcessWithID(ID);
		Proces proces_kopia = processesList.get(index);
		proces_kopia.ReadInformations();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
