package main.java.StartingClass;

import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;


import main.java.GttDatabaseManipulate.PushStructuresToGTTDB;
import main.java.costofmachine.FetchDataForEachMachine;



public class Main {

	protected static final String DEST =  "C://Users/el08/Desktop/programiki/Cost_of_machine/Analiza_maszyn.pdf";
	protected static String text = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {

					//push available projects to database

					PushStructuresToGTTDB DBPusherGTT = new PushStructuresToGTTDB();


					// push Projects and Subprojects to database
					DBPusherGTT.PushOpenProjectListTODB();
					DBPusherGTT.PushSubProjectsToDB();

					// print existing subprojetcs
					DBPusherGTT.getListOfSUbProjects().forEach(System.out::println);




				//	PushGeneralProjectsStructuresToDatabase(DBPusherGTT);
				//	PushSubprojectsStructuresToDatabase();






				} catch (Exception e) {
					e.printStackTrace();
				}
			}



		});
	}

	private static void PushGeneralProjectsStructuresToDatabase(PushStructuresToGTTDB DBPusherGTT) throws IOException, SQLException {

		//clean - TRUNCATE -table with
		DBPusherGTT.TruncateStructurestable();

		// run for each machine in loop, for now only projects, without subprojetcs
		for(int i = 0 ; i < DBPusherGTT.getListOfOpenedMachines().size();i++) {
			FetchDataForEachMachine.run(DBPusherGTT.getListOfOpenedMachines().get(i));
		}
	}

	private static void PushSubprojectsStructuresToDatabase()
	{
		// gather data for all subprojects from subprojects database
		//		CountMaterial2test.run(DBPusherGTT.getListOfOpenedMachines().get(0));
	}
}